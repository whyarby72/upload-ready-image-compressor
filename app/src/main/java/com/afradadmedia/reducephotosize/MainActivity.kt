package com.afradadmedia.reducephotosize

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

private val Canvas = Color(0xFFF6F0ED)
private val SurfaceWarm = Color(0xFFFCF9F6)
private val SurfaceSubtle = Color(0xFFEFE9E4)
private val Ink = Color(0xFF1E3335)
private val InkDeep = Color(0xFF142629)
private val TextSecondary = Color(0xFF5E6C72)
private val Outline = Color(0xFFDED7D1)
private val Success = Color(0xFF2F6C59)
private val SuccessSurface = Color(0xFFE3ECE4)
private val Warning = Color(0xFF9D4447)
private val WarningSurface = Color(0xFFF9E2DE)
private val Info = Color(0xFF4B6668)
private val InfoSurface = Color(0xFFE8EEEC)

private val WarmInkTypography = androidx.compose.material3.Typography(
    displayLarge = androidx.compose.ui.text.TextStyle(fontSize = 52.sp, lineHeight = 56.sp, fontWeight = FontWeight.SemiBold),
    headlineLarge = androidx.compose.ui.text.TextStyle(fontSize = 32.sp, lineHeight = 37.sp, fontWeight = FontWeight.SemiBold),
    headlineMedium = androidx.compose.ui.text.TextStyle(fontSize = 28.sp, lineHeight = 33.sp, fontWeight = FontWeight.SemiBold),
    titleLarge = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, lineHeight = 25.sp, fontWeight = FontWeight.SemiBold),
    titleMedium = androidx.compose.ui.text.TextStyle(fontSize = 16.sp, lineHeight = 21.sp, fontWeight = FontWeight.Medium),
    bodyLarge = androidx.compose.ui.text.TextStyle(fontSize = 16.sp, lineHeight = 23.sp),
    bodyMedium = androidx.compose.ui.text.TextStyle(fontSize = 14.sp, lineHeight = 20.sp),
    labelLarge = androidx.compose.ui.text.TextStyle(fontSize = 15.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
    labelMedium = androidx.compose.ui.text.TextStyle(fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium)
)

class MainActivity : ComponentActivity() {
    private val worker: ExecutorService = Executors.newSingleThreadExecutor()
    private var uiState by mutableStateOf<MainUiState>(MainUiState.Home)
    private var imageInfo: ImageInfo? = null
    private var selectedTargetBytes: Long? = null
    private var selectedTargetIndex: Int? = null
    private var currentResultFile: File? = null
    private val picker = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode != Activity.RESULT_OK) return@registerForActivityResult
        val uri = result.data?.data ?: return@registerForActivityResult
        if (Build.VERSION.SDK_INT < 33) runCatching { contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION) }
        uiState = MainUiState.Inspecting()
        worker.execute {
            runCatching {
                val info = ImageInspector.inspect(this, uri)
                val preview = PreviewLoader.fromUri(this, uri)?.asImageBitmap()
                runOnUiThread {
                    imageInfo = info
                    selectedTargetBytes = null
                    selectedTargetIndex = null
                    uiState = MainUiState.Requirement(info, sourcePreview = preview)
                }
            }.onFailure { error -> runOnUiThread { showError(error.message ?: "Unable to read photo") } }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { WarmInkTheme { ReducePhotoSizeApp(uiState, ::onEvent) } }
    }

    private fun onEvent(event: MainUiEvent) {
        when (event) {
            MainUiEvent.ChoosePhoto -> launchPicker()
            is MainUiEvent.SelectPreset -> {
                selectedTargetBytes = event.bytes
                selectedTargetIndex = event.index
                val current = uiState as? MainUiState.Requirement ?: return
                uiState = current.copy(selectedTargetBytes = event.bytes, selectedTargetIndex = event.index)
            }
            is MainUiEvent.ApplyCustom -> {
                try {
                    val bytes = TargetLimitParser.parse(event.raw, event.megabytes)
                    onEvent(MainUiEvent.SelectPreset(bytes, 5))
                } catch (error: IllegalArgumentException) {
                    val current = uiState as? MainUiState.Requirement ?: return
                    uiState = MainUiState.Failure(error.message ?: "Enter a valid limit", current)
                }
            }
            MainUiEvent.ContinueKnown -> startKnownCompression()
            MainUiEvent.ContinueUnknown -> startUnknownReduction()
            MainUiEvent.Save -> saveResult()
            MainUiEvent.Share -> shareResult()
            MainUiEvent.CompressAnother -> reset()
            MainUiEvent.OpenCustom, MainUiEvent.DismissError -> Unit
        }
    }

    private fun launchPicker() {
        val intent = if (Build.VERSION.SDK_INT >= 33) {
            Intent(MediaStore.ACTION_PICK_IMAGES).setType("image/jpeg")
        } else {
            Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/jpeg"
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
            }
        }
        picker.launch(intent)
    }

    private fun startKnownCompression() {
        val info = imageInfo ?: return
        val target = selectedTargetBytes ?: return
        uiState = MainUiState.Processing(info, if (info.sizeBytes <= target) "Verifying actual size…" else "Compressing on-device…", (uiState as? MainUiState.Requirement)?.sourcePreview)
        worker.execute {
            val result = JpegCompressionEngine.compressKnown(this, info, target)
            finishResult(info, result)
        }
    }

    private fun startUnknownReduction() {
        val info = imageInfo ?: return
        selectedTargetBytes = null
        selectedTargetIndex = null
        uiState = MainUiState.Processing(info, "Making a smaller copy…", (uiState as? MainUiState.Requirement)?.sourcePreview)
        worker.execute {
            val result = JpegCompressionEngine.reduceUnknown(this, info)
            finishResult(info, result)
        }
    }

    private fun finishResult(info: ImageInfo, result: CompressionResult) {
        if (result.state == CompressionResult.State.ERROR) {
            runOnUiThread { showError(result.message ?: "Compression failed") }
            return
        }
        worker.execute {
            val sourcePreview = PreviewLoader.fromUri(this, info.uri)?.asImageBitmap()
            val resultPreview = result.resultFile?.let { PreviewLoader.fromFile(it)?.asImageBitmap() }
            runOnUiThread {
                currentResultFile = result.resultFile
                uiState = MainUiState.Result(info, result, sourcePreview, resultPreview)
            }
        }
    }

    private fun saveResult() {
        val file = currentResultFile ?: return
        worker.execute {
            runCatching { MediaStoreSaver.saveJpeg(this, file) }
                .onSuccess { runOnUiThread { Toast.makeText(this, "Saved to Pictures/Reduce Photo Size", Toast.LENGTH_LONG).show() } }
                .onFailure { error -> runOnUiThread { showError(error.message ?: "Save failed") } }
        }
    }

    private fun shareResult() {
        if (currentResultFile?.isFile != true) return
        val send = Intent(Intent.ACTION_SEND).apply {
            type = "image/jpeg"
            putExtra(Intent.EXTRA_STREAM, ResultContentProvider.RESULT_URI)
            clipData = ClipData.newRawUri("Reduce Photo Size result", ResultContentProvider.RESULT_URI)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(send, "Share upload-ready photo"))
    }

    private fun reset() {
        imageInfo = null
        selectedTargetBytes = null
        selectedTargetIndex = null
        currentResultFile = null
        uiState = MainUiState.Home
    }

    private fun showError(message: String) {
        val recover = when (val current = uiState) {
            is MainUiState.Requirement -> current
            is MainUiState.Processing -> MainUiState.Requirement(current.image, selectedTargetBytes, selectedTargetIndex, current.sourcePreview)
            else -> MainUiState.Home
        }
        uiState = MainUiState.Failure(message, recover)
    }

    override fun onDestroy() { worker.shutdownNow(); super.onDestroy() }
}

@Composable
private fun WarmInkTheme(content: @Composable () -> Unit) { androidx.compose.material3.MaterialTheme(colorScheme = androidx.compose.material3.lightColorScheme(primary = Ink, onPrimary = Color.White, background = Canvas, onBackground = InkDeep, surface = SurfaceWarm, onSurface = InkDeep, surfaceVariant = SurfaceSubtle, outline = Outline), typography = WarmInkTypography, content = content) }

@Composable
private fun ReducePhotoSizeApp(state: MainUiState, onEvent: (MainUiEvent) -> Unit) {
    var customOpen by remember { mutableStateOf(false) }
    val actualState = if (state is MainUiState.Failure) state.recoverTo else state
    Scaffold(containerColor = Canvas) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).statusBarsPadding().navigationBarsPadding().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp, vertical = 16.dp)) {
            AppHeader()
            Spacer(Modifier.height(28.dp))
            when (actualState) {
                MainUiState.Home -> HomeScreen { onEvent(MainUiEvent.ChoosePhoto) }
                is MainUiState.Inspecting -> ProcessingScreen(actualState.message)
                is MainUiState.Requirement -> RequirementScreen(actualState, onEvent, { customOpen = true })
                is MainUiState.Processing -> ProcessingScreen(actualState.message, actualState.sourcePreview)
                is MainUiState.Result -> ResultScreen(actualState, onEvent)
                is MainUiState.Failure -> Unit
            }
            if (state is MainUiState.Failure && actualState !is MainUiState.Requirement) {
                Spacer(Modifier.height(16.dp))
                Text(state.message, color = Warning, fontSize = 14.sp, modifier = Modifier.fillMaxWidth())
            }
        }
    }
    if (customOpen) {
        CustomLimitDialog(
            onDismiss = { customOpen = false },
            onApply = { raw, mb ->
                try {
                    val bytes = TargetLimitParser.parse(raw, mb)
                    onEvent(MainUiEvent.SelectPreset(bytes, 5))
                    customOpen = false
                    true
                } catch (_: IllegalArgumentException) {
                    false
                }
            }
        )
    }
}

@Composable private fun AppHeader() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(painterResource(R.drawable.ic_brand_compress_frame), "Reduce Photo Size", tint = Ink, modifier = Modifier.size(26.dp))
        Spacer(Modifier.width(10.dp))
        Text("Reduce Photo Size", color = InkDeep, style = WarmInkTypography.titleLarge, modifier = Modifier.weight(1f), maxLines = 1)
    }
    Spacer(Modifier.height(8.dp)); Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) { TrustCue() }
}

@Composable private fun HomeScreen(onChoose: () -> Unit) {
    Text("Fit your photo to an upload limit.", color = InkDeep, style = WarmInkTypography.headlineLarge)
    Spacer(Modifier.height(22.dp))
    Surface(color = SurfaceWarm, shape = RoundedCornerShape(28.dp), modifier = Modifier.fillMaxWidth().border(1.dp, Outline, RoundedCornerShape(28.dp))) {
        Column(Modifier.padding(20.dp)) {
            Image(painterResource(R.drawable.ill_home_fit_to_limit), "Photo fitted to an upload limit", modifier = Modifier.fillMaxWidth().height(190.dp).clip(RoundedCornerShape(22.dp)), contentScale = ContentScale.Fit)
        }
    }
    Spacer(Modifier.height(22.dp)); PrimaryButton("Choose photo", R.drawable.ic_photo, onChoose); Spacer(Modifier.height(12.dp)); Text("On-device · original untouched", color = TextSecondary, style = WarmInkTypography.labelMedium, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
}

@Composable private fun RequirementScreen(state: MainUiState.Requirement, dispatch: (MainUiEvent) -> Unit, openCustom: () -> Unit) {
    Text("Choose limit", color = InkDeep, style = WarmInkTypography.headlineMedium)
    Spacer(Modifier.height(20.dp)); RequirementMediaCard(state.sourcePreview, FormatUtils.bytes(state.image.sizeBytes), "${state.image.width} × ${state.image.height} · JPEG")
    Spacer(Modifier.height(24.dp)); Text("UPLOAD LIMIT", color = Info, style = WarmInkTypography.labelMedium)
    Spacer(Modifier.height(12.dp)); val labels = listOf("50 KB", "100 KB", "200 KB", "500 KB", "1 MB")
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) { labels.take(3).forEachIndexed { i, label -> LimitChip(label, state.selectedTargetIndex == i, modifier = Modifier.weight(1f)) { dispatch(MainUiEvent.SelectPreset(listOf(50_000L, 100_000L, 200_000L)[i], i)) } } }
    Spacer(Modifier.height(8.dp)); Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) { labels.drop(3).forEachIndexed { offset, label -> val i = offset + 3; LimitChip(label, state.selectedTargetIndex == i, modifier = Modifier.weight(1f)) { dispatch(MainUiEvent.SelectPreset(listOf(500_000L, 1_000_000L)[offset], i)) } }; LimitChip("Custom", state.selectedTargetIndex == 5, modifier = Modifier.weight(1f), onClick = openCustom) }
    if (state.selectedTargetBytes != null) { Spacer(Modifier.height(14.dp)); Text("Required ≤ ${FormatUtils.target(state.selectedTargetBytes)}", color = Info, style = WarmInkTypography.labelLarge) }
    Spacer(Modifier.height(20.dp)); PrimaryButton("Continue", R.drawable.ic_target, { if (state.selectedTargetBytes != null) dispatch(MainUiEvent.ContinueKnown) }, enabled = state.selectedTargetBytes != null); Spacer(Modifier.height(4.dp)); TextButton(onClick = { dispatch(MainUiEvent.ContinueUnknown) }, modifier = Modifier.fillMaxWidth()) { Text("I don't know the limit", color = TextSecondary, style = WarmInkTypography.labelLarge) }
}

@Composable private fun ProcessingScreen(message: String, preview: ImageBitmap? = null) { Column(Modifier.fillMaxWidth().padding(top = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) { PreviewBox(preview, Modifier.fillMaxWidth().height(300.dp), ContentScale.Fit); Spacer(Modifier.height(18.dp)); Row(verticalAlignment = Alignment.CenterVertically) { CircularProgressIndicator(color = Ink, modifier = Modifier.size(22.dp), strokeWidth = 2.dp); Spacer(Modifier.width(12.dp)); Text(message.replace(" on-device", ""), color = InkDeep, style = WarmInkTypography.titleLarge) }; Spacer(Modifier.height(8.dp)); Text("Original untouched", color = TextSecondary, style = WarmInkTypography.bodyMedium, textAlign = TextAlign.Center) } }

@Composable private fun ResultScreen(state: MainUiState.Result, onEvent: (MainUiEvent) -> Unit) {
    val result = state.result; val pass = result.state == CompressionResult.State.PASS || result.state == CompressionResult.State.ALREADY_READY; val reduced = result.state == CompressionResult.State.REDUCED || result.state == CompressionResult.State.ALREADY_SMALL; val notMet = !pass && !reduced; val accent = if (pass) Success else if (reduced) Info else Warning; val tint = if (pass) SuccessSurface else if (reduced) InfoSurface else WarningSurface
    val resultValueStyle = WarmInkTypography.displayLarge.copy(fontSize = if (result.outputBytes >= 10_000_000L) 36.sp else if (result.outputBytes >= 1_000_000L) 42.sp else 50.sp, lineHeight = if (result.outputBytes >= 10_000_000L) 40.sp else if (result.outputBytes >= 1_000_000L) 46.sp else 54.sp)
    Surface(color = SurfaceWarm, shape = RoundedCornerShape(28.dp), modifier = Modifier.fillMaxWidth().border(1.dp, Outline, RoundedCornerShape(28.dp))) { Column(Modifier.padding(14.dp)) { PreviewBox(state.resultPreview, Modifier.fillMaxWidth().height(252.dp), ContentScale.Fit); Spacer(Modifier.height(16.dp)); Surface(color = tint, shape = RoundedCornerShape(50)) { Text(if (pass) "MEETS LIMIT" else if (reduced) "SMALLER COPY" else "TARGET NOT MET", color = accent, style = WarmInkTypography.labelMedium, modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)) }; Spacer(Modifier.height(8.dp)); Text(FormatUtils.bytes(result.outputBytes), color = InkDeep, style = resultValueStyle, maxLines = 1, softWrap = false, modifier = Modifier.fillMaxWidth()) } }
    Spacer(Modifier.height(14.dp)); Surface(color = InfoSurface, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) { Text(if (pass) "${result.outputBytes} bytes ≤ ${result.targetBytes} bytes — PASS" else if (reduced) "No upload limit entered — no PASS claim" else "${result.outputBytes} bytes > ${result.targetBytes} bytes — NOT_MET", color = accent, style = WarmInkTypography.bodyMedium, modifier = Modifier.padding(14.dp)) }
    if (notMet) { Spacer(Modifier.height(10.dp)); Text("Try a higher limit or a different photo.", color = Warning, style = WarmInkTypography.bodyMedium, modifier = Modifier.fillMaxWidth()) }
    Spacer(Modifier.height(14.dp)); BeforeAfterCard(state.sourcePreview, state.resultPreview, result); Spacer(Modifier.height(8.dp)); Text("${result.width} × ${result.height} · JPEG · original untouched", color = TextSecondary, style = WarmInkTypography.bodyMedium)
    Spacer(Modifier.height(20.dp)); PrimaryButton(if (notMet) "Save current copy" else "Save copy", R.drawable.ic_download, { onEvent(MainUiEvent.Save) }); Spacer(Modifier.height(10.dp)); Row(Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(SurfaceWarm).border(1.dp, Outline, RoundedCornerShape(20.dp))) { CompactAction("Share", R.drawable.ic_share, Modifier.weight(1f)) { onEvent(MainUiEvent.Share) }; Box(Modifier.width(1.dp).height(48.dp).background(Outline)); CompactAction("Compress another", R.drawable.ic_repeat, Modifier.weight(1f)) { onEvent(MainUiEvent.CompressAnother) } }
}

@Composable private fun RequirementMediaCard(preview: ImageBitmap?, size: String, meta: String) { Surface(color = SurfaceWarm, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth().border(1.dp, Outline, RoundedCornerShape(20.dp))) { Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) { PreviewBox(preview, Modifier.size(92.dp), ContentScale.Crop); Spacer(Modifier.width(12.dp)); Column(Modifier.weight(1f)) { Text("CURRENT PHOTO", color = Info, style = WarmInkTypography.labelMedium); Spacer(Modifier.height(2.dp)); Text(size, color = InkDeep, style = WarmInkTypography.titleLarge, maxLines = 1, softWrap = false); Text(meta, color = TextSecondary, style = WarmInkTypography.bodyMedium, maxLines = 1, softWrap = false) } } } }
@Composable private fun BeforeAfterCard(source: ImageBitmap?, result: ImageBitmap?, data: CompressionResult) { Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) { Column(Modifier.weight(1f)) { PreviewBox(source, Modifier.fillMaxWidth().height(112.dp), ContentScale.Fit); Spacer(Modifier.height(7.dp)); Text("CURRENT\n${FormatUtils.bytes(data.sourceBytes)}", color = TextSecondary, fontSize = 12.sp) }; Column(Modifier.weight(1f)) { PreviewBox(result, Modifier.fillMaxWidth().height(112.dp), ContentScale.Fit); Spacer(Modifier.height(7.dp)); Text("RESULT\n${FormatUtils.bytes(data.outputBytes)}", color = InkDeep, fontSize = 12.sp, fontWeight = FontWeight.Medium) } } }
@Composable private fun PreviewBox(image: ImageBitmap?, modifier: Modifier, contentScale: ContentScale = ContentScale.Fit) { Box(modifier.clip(RoundedCornerShape(18.dp)).background(SurfaceSubtle), contentAlignment = Alignment.Center) { if (image != null) Image(image, "Photo preview", modifier = Modifier.fillMaxSize(), contentScale = contentScale) else Icon(painterResource(R.drawable.ic_photo), "Photo", tint = Info, modifier = Modifier.size(38.dp)) } }
@Composable private fun LimitChip(label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) { OutlinedButton(onClick = onClick, modifier = modifier.height(48.dp).semantics { this.selected = selected; contentDescription = if (selected) "$label, selected" else label }, shape = RoundedCornerShape(16.dp), contentPadding = PaddingValues(horizontal = 3.dp, vertical = 0.dp), colors = ButtonDefaults.outlinedButtonColors(containerColor = if (selected) InfoSurface else SurfaceWarm, contentColor = InkDeep), border = androidx.compose.foundation.BorderStroke(1.dp, if (selected) Ink else Outline)) { if (selected) { Icon(painterResource(R.drawable.ic_check_small), null, tint = Ink, modifier = Modifier.size(13.dp)); Spacer(Modifier.width(2.dp)) }; Text(label, style = WarmInkTypography.labelMedium, maxLines = 1, softWrap = false) } }
@Composable private fun PrimaryButton(label: String, icon: Int, onClick: () -> Unit, enabled: Boolean = true) { Button(onClick = onClick, enabled = enabled, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(24.dp), colors = ButtonDefaults.buttonColors(containerColor = Ink, contentColor = Color.White, disabledContainerColor = Outline, disabledContentColor = TextSecondary)) { Icon(painterResource(icon), null, modifier = Modifier.size(20.dp)); Spacer(Modifier.width(8.dp)); Text(label, fontSize = 16.sp, fontWeight = FontWeight.SemiBold) } }
@Composable private fun SecondaryButton(label: String, icon: Int, onClick: () -> Unit) { OutlinedButton(onClick = onClick, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(22.dp), colors = ButtonDefaults.outlinedButtonColors(containerColor = SurfaceWarm, contentColor = InkDeep), border = androidx.compose.foundation.BorderStroke(1.dp, Outline)) { Icon(painterResource(icon), null, modifier = Modifier.size(19.dp)); Spacer(Modifier.width(8.dp)); Text(label, fontSize = 15.sp, fontWeight = FontWeight.Medium) } }
@Composable private fun CompactAction(label: String, icon: Int, modifier: Modifier, onClick: () -> Unit) { TextButton(onClick = onClick, modifier = modifier.height(48.dp)) { Icon(painterResource(icon), null, tint = Info, modifier = Modifier.size(18.dp)); Spacer(Modifier.width(6.dp)); Text(label, color = InkDeep, style = WarmInkTypography.labelMedium, maxLines = 1) } }
@Composable private fun TrustCue() { Surface(color = SuccessSurface, shape = RoundedCornerShape(50)) { Text("On-device", color = Success, style = WarmInkTypography.labelMedium, modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) } }
@Composable private fun CustomLimitDialog(onDismiss: () -> Unit, onApply: (String, Boolean) -> Boolean) { var raw by remember { mutableStateOf("") }; var mb by remember { mutableStateOf(false) }; var validation by remember { mutableStateOf<String?>(null) }; AlertDialog(onDismissRequest = onDismiss, containerColor = SurfaceWarm, title = { Text("Custom limit", color = InkDeep, style = WarmInkTypography.titleLarge) }, text = { Column { Text("Use a dot or comma for decimals · up to 3 decimal places", color = TextSecondary, style = WarmInkTypography.bodyMedium); Spacer(Modifier.height(12.dp)); OutlinedTextField(value = raw, onValueChange = { raw = it; validation = null }, isError = validation != null, supportingText = { if (validation != null) Text(validation!!, color = Warning) }, singleLine = true, label = { Text("Amount") }); Spacer(Modifier.height(10.dp)); Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { LimitChip("KB", !mb, modifier = Modifier.weight(1f)) { mb = false }; LimitChip("MB", mb, modifier = Modifier.weight(1f)) { mb = true } } } }, confirmButton = { TextButton(onClick = { if (!onApply(raw, mb)) validation = "Use a valid number with up to 3 decimal places." }) { Text("Use limit", color = Ink, fontWeight = FontWeight.SemiBold) } }, dismissButton = { TextButton(onClick = onDismiss) { Text("Cancel", color = TextSecondary) } }) }
