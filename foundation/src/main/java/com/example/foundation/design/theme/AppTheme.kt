package com.example.foundation.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

@Composable
fun AppTheme(
    dimensions: AppDimensions = AppTheme.dimensions,
    content: @Composable () -> Unit,
) {
    val appColors = remember { lightThemeColors() }
    CompositionLocalProvider(
        LocalColors provides appColors,
        LocalDimensions provides dimensions,
    ) {
        content()
    }
}