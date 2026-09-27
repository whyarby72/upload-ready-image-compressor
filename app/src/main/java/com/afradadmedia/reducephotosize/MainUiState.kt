package com.afradadmedia.reducephotosize

import androidx.compose.ui.graphics.ImageBitmap

internal sealed interface MainUiState {
    data object Home : MainUiState
    data class Inspecting(val message: String = "Reading photo…") : MainUiState
    data class Requirement(
        val image: ImageInfo,
        val selectedTargetBytes: Long? = null,
        val selectedTargetIndex: Int? = null,
        val sourcePreview: ImageBitmap? = null
    ) : MainUiState
    data class Processing(
        val image: ImageInfo,
        val message: String,
        val sourcePreview: ImageBitmap? = null
    ) : MainUiState
    data class Result(
        val source: ImageInfo,
        val result: CompressionResult,
        val sourcePreview: ImageBitmap?,
        val resultPreview: ImageBitmap?
    ) : MainUiState
    data class Failure(val message: String, val recoverTo: MainUiState) : MainUiState
}
