package com.afradadmedia.reducephotosize

internal sealed interface MainUiEvent {
    data object ChoosePhoto : MainUiEvent
    data class SelectPreset(val bytes: Long, val index: Int) : MainUiEvent
    data object OpenCustom : MainUiEvent
    data class ApplyCustom(val raw: String, val megabytes: Boolean) : MainUiEvent
    data object ContinueKnown : MainUiEvent
    data object ContinueUnknown : MainUiEvent
    data object Save : MainUiEvent
    data object Share : MainUiEvent
    data object CompressAnother : MainUiEvent
    data object DismissError : MainUiEvent
}
