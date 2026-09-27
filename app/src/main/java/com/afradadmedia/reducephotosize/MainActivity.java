package com.afradadmedia.reducephotosize;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class MainActivity extends Activity {
    private static final int PICK_REQUEST = 42;
    private final ExecutorService worker = Executors.newSingleThreadExecutor();

    private LinearLayout homePanel, requirementPanel, progressPanel, resultPanel;
    private TextView currentSizeText, currentMetaText, selectedTargetText, progressText;
    private TextView resultStateText, resultSizeText, resultProofText, resultChangeText, resultDimensionsText, resultNoticeText, errorText, resultBeforeText, resultAfterText;
    private android.widget.ImageView resultStatusIcon;
    private View resultStatusRow;
    private Button makeReadyButton, unknownLimitButton, shareButton, saveButton, anotherButton;
    private Button[] targetButtons;

    private ImageInfo imageInfo;
    private long selectedTargetBytes;
    private File currentResultFile;
    private CompressionResult currentResult;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        bindActions();
        clearTargetSelection();
    }

    private void bindViews() {
        homePanel = findViewById(R.id.homePanel);
        requirementPanel = findViewById(R.id.requirementPanel);
        progressPanel = findViewById(R.id.progressPanel);
        resultPanel = findViewById(R.id.resultPanel);
        currentSizeText = findViewById(R.id.currentSizeText);
        currentMetaText = findViewById(R.id.currentMetaText);
        selectedTargetText = findViewById(R.id.selectedTargetText);
        progressText = findViewById(R.id.progressText);
        resultStateText = findViewById(R.id.resultStateText);
        resultSizeText = findViewById(R.id.resultSizeText);
        resultProofText = findViewById(R.id.resultProofText);
        resultDimensionsText = findViewById(R.id.resultDimensionsText);
        resultNoticeText = findViewById(R.id.resultNoticeText);
        resultBeforeText = findViewById(R.id.resultBeforeText);
        resultAfterText = findViewById(R.id.resultAfterText);
        resultStatusIcon = findViewById(R.id.resultStatusIcon);
        resultStatusRow = findViewById(R.id.resultStatusRow);
        errorText = findViewById(R.id.errorText);
        makeReadyButton = findViewById(R.id.makeReadyButton);
        unknownLimitButton = findViewById(R.id.unknownLimitButton);
        shareButton = findViewById(R.id.shareButton);
        saveButton = findViewById(R.id.saveButton);
        anotherButton = findViewById(R.id.anotherButton);
        targetButtons = new Button[]{findViewById(R.id.target50), findViewById(R.id.target100), findViewById(R.id.target200), findViewById(R.id.target500), findViewById(R.id.target1m), findViewById(R.id.targetCustom)};
    }

    private void bindActions() {
        findViewById(R.id.choosePhotoButton).setOnClickListener(v -> launchPicker());
        targetButtons[0].setOnClickListener(v -> selectTarget(50_000L, 0));
        targetButtons[1].setOnClickListener(v -> selectTarget(100_000L, 1));
        targetButtons[2].setOnClickListener(v -> selectTarget(200_000L, 2));
        targetButtons[3].setOnClickListener(v -> selectTarget(500_000L, 3));
        targetButtons[4].setOnClickListener(v -> selectTarget(1_000_000L, 4));
        targetButtons[5].setOnClickListener(v -> showCustomTargetDialog());
        makeReadyButton.setOnClickListener(v -> startKnownCompression());
        unknownLimitButton.setOnClickListener(v -> startUnknownReduction());
        shareButton.setOnClickListener(v -> shareResult());
        saveButton.setOnClickListener(v -> saveResult());
        anotherButton.setOnClickListener(v -> reset());
    }

    private void launchPicker() {
        hideError();
        Intent intent;
        if (Build.VERSION.SDK_INT >= 33) {
            intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
            intent.setType("image/jpeg");
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/jpeg");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        }
        startActivityForResult(intent, PICK_REQUEST);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != PICK_REQUEST || resultCode != RESULT_OK || data == null || data.getData() == null) return;
        Uri uri = data.getData();
        if (Build.VERSION.SDK_INT < 33) {
            try {
                getContentResolver().takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } catch (Exception ignored) { }
        }
        setBusy("Reading photo…");
        worker.execute(() -> {
            try {
                ImageInfo inspected = ImageInspector.inspect(this, uri);
                runOnUiThread(() -> showRequirement(inspected));
            } catch (Exception e) {
                runOnUiThread(() -> showError(e.getMessage() == null ? "Unable to read photo" : e.getMessage()));
            }
        });
    }

    private void showRequirement(ImageInfo info) {
        imageInfo = info;
        clearTargetSelection();
        homePanel.setVisibility(View.GONE);
        progressPanel.setVisibility(View.GONE);
        resultPanel.setVisibility(View.GONE);
        requirementPanel.setVisibility(View.VISIBLE);
        currentSizeText.setText(FormatUtils.bytes(info.sizeBytes));
        currentMetaText.setText(info.width + " × " + info.height + " · JPEG · detected on-device");
        hideError();
    }

    private void selectTarget(long bytes, int index) {
        if (bytes < TargetLimitParser.MIN_BYTES || bytes > TargetLimitParser.MAX_BYTES) return;
        selectedTargetBytes = bytes;
        selectedTargetText.setText("Required ≤ " + FormatUtils.target(bytes));
        makeReadyButton.setEnabled(imageInfo != null);
        for (int i = 0; i < targetButtons.length; i++) {
            targetButtons[i].setSelected(i == index);
            targetButtons[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, i == index ? R.drawable.ic_check_small : 0, 0);
            targetButtons[i].setContentDescription(i == index ? targetButtons[i].getText() + ", selected" : targetButtons[i].getText().toString());
        }
    }

    private void showCustomTargetDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom_limit);
        dialog.setCanceledOnTouchOutside(true);
        EditText input = dialog.findViewById(R.id.customLimitInput);
        TextView kb = dialog.findViewById(R.id.unitKb);
        TextView mb = dialog.findViewById(R.id.unitMb);
        TextView validation = dialog.findViewById(R.id.customLimitValidation);
        final boolean[] megabytes = {false};
        View.OnClickListener kbListener = v -> {
            megabytes[0] = false;
            kb.setBackgroundResource(R.drawable.segment_selected);
            kb.setTextColor(getColor(R.color.ur_text));
            mb.setBackgroundResource(R.drawable.segment_unselected);
            mb.setTextColor(getColor(R.color.ur_muted));
        };
        View.OnClickListener mbListener = v -> {
            megabytes[0] = true;
            mb.setBackgroundResource(R.drawable.segment_selected);
            mb.setTextColor(getColor(R.color.ur_text));
            kb.setBackgroundResource(R.drawable.segment_unselected);
            kb.setTextColor(getColor(R.color.ur_muted));
        };
        kb.setOnClickListener(kbListener);
        mb.setOnClickListener(mbListener);
        dialog.findViewById(R.id.customLimitCancel).setOnClickListener(v -> dialog.dismiss());
        dialog.findViewById(R.id.customLimitUse).setOnClickListener(v -> {
            try {
                long bytes = TargetLimitParser.parse(input.getText().toString(), megabytes[0]);
                selectTarget(bytes, 5);
                dialog.dismiss();
            } catch (IllegalArgumentException ex) {
                validation.setText(ex.getMessage());
                validation.setVisibility(View.VISIBLE);
                input.requestFocus();
            }
        });
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            window.setLayout(Math.min(dp(360), getResources().getDisplayMetrics().widthPixels - dp(32)), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private void startKnownCompression() {
        if (imageInfo == null || selectedTargetBytes <= 0) return;
        final ImageInfo imageSnapshot = imageInfo;
        final long targetSnapshot = selectedTargetBytes;
        setBusy(imageSnapshot.sizeBytes <= targetSnapshot ? "Verifying actual size…" : "Compressing on-device…");
        worker.execute(() -> {
            CompressionResult r = JpegCompressionEngine.compressKnown(this, imageSnapshot, targetSnapshot);
            runOnUiThread(() -> showResult(r));
        });
    }

    private void startUnknownReduction() {
        if (imageInfo == null) return;
        final ImageInfo imageSnapshot = imageInfo;
        clearTargetSelection();
        setBusy("Making a smaller copy…");
        worker.execute(() -> {
            CompressionResult r = JpegCompressionEngine.reduceUnknown(this, imageSnapshot);
            runOnUiThread(() -> showResult(r));
        });
    }

    private void setBusy(String message) {
        homePanel.setVisibility(View.GONE);
        requirementPanel.setVisibility(View.GONE);
        resultPanel.setVisibility(View.GONE);
        progressPanel.setVisibility(View.VISIBLE);
        progressText.setText(message);
        hideError();
    }

    private void showResult(CompressionResult r) {
        currentResult = r;
        currentResultFile = r.resultFile;
        progressPanel.setVisibility(View.GONE);
        requirementPanel.setVisibility(View.GONE);
        resultPanel.setVisibility(View.VISIBLE);
        hideError();

        resultSizeText.setText(FormatUtils.bytes(r.outputBytes));
        resultBeforeText.setText(FormatUtils.bytes(r.sourceBytes));
        resultAfterText.setText(FormatUtils.bytes(r.outputBytes));
        if (resultChangeText != null) resultChangeText.setText("CURRENT " + FormatUtils.bytes(r.sourceBytes) + "  →  RESULT " + FormatUtils.bytes(r.outputBytes));
        resultDimensionsText.setText(r.width + " × " + r.height + " · JPEG quality " + (r.jpegQuality == 100 ? "unchanged" : r.jpegQuality));
        resultNoticeText.setText(r.message == null ? "" : r.message);
        shareButton.setEnabled(r.resultFile != null);
        saveButton.setEnabled(r.resultFile != null);

        switch (r.state) {
            case PASS:
            case ALREADY_READY:
                resultStateText.setText("MEETS LIMIT");
                resultStateText.setTextColor(getColor(R.color.ur_success));
                resultStatusIcon.setImageResource(R.drawable.ic_check_circle);
                resultStatusRow.setBackgroundResource(R.drawable.status_success);
                resultStatusIcon.setContentDescription("Meets limit");
                resultNoticeText.setText("The file meets the maximum size you entered.");
                resultProofText.setText(r.outputBytes + " bytes ≤ " + r.targetBytes + " bytes — PASS");
                resultProofText.setTextColor(getColor(R.color.ur_success));
                break;
            case REDUCED:
                resultStateText.setText("SMALLER COPY");
                resultStateText.setTextColor(getColor(R.color.ur_info));
                resultStatusIcon.setImageResource(R.drawable.ic_info);
                resultStatusRow.setBackgroundResource(R.drawable.status_info);
                resultStatusIcon.setContentDescription("Smaller copy");
                resultNoticeText.setText("No upload limit was entered, so compatibility isn't verified.");
                resultProofText.setText("No upload limit entered — no PASS claim");
                resultProofText.setTextColor(getColor(R.color.ur_info));
                break;
            case ALREADY_SMALL:
                resultStateText.setText("SMALLER COPY");
                resultStateText.setTextColor(getColor(R.color.ur_info));
                resultStatusIcon.setImageResource(R.drawable.ic_info);
                resultStatusRow.setBackgroundResource(R.drawable.status_info);
                resultStatusIcon.setContentDescription("Smaller copy");
                resultNoticeText.setText("No upload limit was entered, so compatibility isn't verified.");
                resultProofText.setText("No upload limit entered — no PASS claim");
                resultProofText.setTextColor(getColor(R.color.ur_info));
                break;
            case NOT_MET:
                resultStateText.setText("TARGET NOT MET");
                resultStateText.setTextColor(getColor(R.color.ur_warning));
                resultStatusIcon.setImageResource(R.drawable.ic_warning);
                resultStatusRow.setBackgroundResource(R.drawable.status_warning);
                resultStatusIcon.setContentDescription("Target not met");
                resultNoticeText.setText("We stopped before quality dropped below the app's safety guard.");
                resultProofText.setText(r.outputBytes + " bytes > " + r.targetBytes + " bytes — NOT_MET");
                resultProofText.setTextColor(getColor(R.color.ur_warning));
                break;
            case ERROR:
            default:
                resultPanel.setVisibility(View.GONE);
                showError(r.message == null ? "Compression failed" : r.message);
        }
    }

    private void shareResult() {
        if (currentResultFile == null || !currentResultFile.isFile()) return;
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("image/jpeg");
        send.putExtra(Intent.EXTRA_STREAM, ResultContentProvider.RESULT_URI);
        send.setClipData(ClipData.newRawUri("Reduce Photo Size result", ResultContentProvider.RESULT_URI));
        send.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(send, "Share upload-ready photo"));
    }

    private void saveResult() {
        if (currentResultFile == null || !currentResultFile.isFile()) return;
        saveButton.setEnabled(false);
        worker.execute(() -> {
            try {
                Uri saved = MediaStoreSaver.saveJpeg(this, currentResultFile);
                runOnUiThread(() -> {
                    saveButton.setEnabled(true);
                    Toast.makeText(this, "Saved to Pictures/Reduce Photo Size", Toast.LENGTH_LONG).show();
                });
            } catch (Exception e) {
                runOnUiThread(() -> {
                    saveButton.setEnabled(true);
                    showError(e.getMessage() == null ? "Save failed" : e.getMessage());
                });
            }
        });
    }

    private void reset() {
        imageInfo = null;
        clearTargetSelection();
        currentResult = null;
        currentResultFile = null;
        resultPanel.setVisibility(View.GONE);
        progressPanel.setVisibility(View.GONE);
        requirementPanel.setVisibility(View.GONE);
        homePanel.setVisibility(View.VISIBLE);
        hideError();
    }

    private void showError(String message) {
        progressPanel.setVisibility(View.GONE);
        errorText.setText(message);
        errorText.setVisibility(View.VISIBLE);
        if (imageInfo != null && resultPanel.getVisibility() != View.VISIBLE) {
            requirementPanel.setVisibility(View.VISIBLE);
        } else if (imageInfo == null) {
            homePanel.setVisibility(View.VISIBLE);
        }
    }

    private void hideError() { errorText.setVisibility(View.GONE); }

    private void clearTargetSelection() {
        selectedTargetBytes = 0L;
        if (selectedTargetText != null) selectedTargetText.setText("Choose the upload limit");
        if (makeReadyButton != null) makeReadyButton.setEnabled(false);
        if (targetButtons != null) {
            for (Button button : targetButtons) {
                button.setSelected(false);
                button.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                button.setContentDescription(button.getText().toString());
            }
        }
    }
    private int dp(int v) { return Math.round(v * getResources().getDisplayMetrics().density); }

    @Override protected void onDestroy() {
        worker.shutdownNow();
        super.onDestroy();
    }
}
