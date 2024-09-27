package com.example.foundation.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AppDimensions(
    val text_size_default: TextUnit = 14.sp,
    val text_size_tag: TextUnit = 10.sp,
    val text_size_description: TextUnit = 12.sp,
    val text_size_body_medium: TextUnit = 16.sp,
    val text_size_title: TextUnit = 22.sp,
    val text_size_subtitle_regular: TextUnit = 21.sp,
    val text_size_subtitle_small: TextUnit = 18.sp,
    val text_size_h1: TextUnit = 48.sp,
    val text_size_h2: TextUnit = 42.sp,
    val text_size_h3: TextUnit = 32.sp,
    val text_size_h4: TextUnit = 24.sp,
)

// Corner radius
val xxs_corner_radius = 2.dp
val xs_corner_radius = 4.dp
val xss_corner_radius = 6.dp
val s_corner_radius = 8.dp
val sm_corner_radius = 10.dp
val smm_corner_radius = 12.dp
val xsm_corner_Radius = 14.dp
val m_corner_radius = 16.dp
val xm_corner_radius = 20.dp
val l_corner_radius = 24.dp
val xxxl_corner_radius = 48.dp

// Line height
val line_height_default = 16.sp
val line_height_xs = 12.sp
val line_height_tag = 19.sp
val line_height_subtitle_small = 21.sp
val line_height_body_medium = 24.sp
val line_height_body_regular = 18.sp
val line_height_h1 = 56.sp
val line_height_h2 = 48.sp
val line_height_h3 = 36.sp
val line_height_h4 = 28.sp

// Text size
val text_size_default = 14.sp
val text_size_tag = 10.sp
val text_size_body_medium = 16.sp
val text_size_title = 22.sp
val text_size_subtitle_small = 18.sp
val text_size_subtitle_regular = 21.sp
val text_size_h1 = 48.sp
val text_size_h2 = 42.sp
val text_size_h3 = 32.sp
val text_size_h4 = 24.sp

// Stroke width
val xxs_stroke_width = 1.dp
val xs_stroke_width = 2.dp

// Letter spacing
val letter_spacing_xxs = 1.sp
val letter_spacing_xs = 2.sp


val LocalDimensions = staticCompositionLocalOf {
    AppDimensions()
}
