package com.example.foundation.design.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val colorPrimary = Color(0xff4F46E5)
val colorOnPrimary = Color(0xffFFFFFF)
val colorPrimaryVariant = Color(0xffECEAE1)
val background = Color(0xffFFFFFF)
val colorSecondary = Color(0xff707070)
val colorOnSecondary = Color(0xffFFFFFF)
val colorSecondaryVariant = Color(0xff38539A)
val colorSurface = Color(0xffFFFFFF)
val colorError = Color(0xffb00020)
val colorOnError = Color(0xffb00020)
val colorOnSurface = Color(0xff000000)

val greyTextColor = Color(0xff6F6B6D)
val greyBgColor = Color(0xffE5E5E5)
val greyContainerColor = Color(0xFFFBFBFB)
val greyBorderColor = Color(0xFFEFEFEF)
val greyIconColor = Color(0xFF9B9B9B)
val lightGreyTextColor = Color(0xff9B9B9B)
val lightWhiteBgColor = Color(0xffFAFAFA)
val disableButtonBg = Color(0xffD9D9D9)

class AppColors(
    primary: Color,
    colorOnPrimary: Color,
    colorPrimaryVariant: Color,
    background: Color,
    colorSecondary: Color,
    colorOnSecondary: Color,
    colorSecondaryVariant: Color,
    colorSurface: Color,
    colorError: Color,
    colorOnError: Color,
    colorOnSurface: Color,
    greyBgColor: Color,
    greyTextColor: Color,
    disableButtonBg: Color,
    lightWhiteBgColor: Color,
    lightGreyTextColor: Color,
    greyContainerColor: Color,
    greyBorderColor: Color,
    greyIconColor: Color,
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(colorOnPrimary)
        private set
    var primaryVariant by mutableStateOf(colorPrimaryVariant)
        private set
    var background by mutableStateOf(background)
        private set
    var secondary by mutableStateOf(colorSecondary)
        private set
    var onSecondary by mutableStateOf(colorOnSecondary)
        private set
    var secondaryVariant by mutableStateOf(colorSecondaryVariant)
        private set
    var colorSurface by mutableStateOf(colorSurface)
        private set
    var error by mutableStateOf(colorError)
        private set
    var onError by mutableStateOf(colorOnError)
        private set
    var onSurface by mutableStateOf(colorOnSurface)
        private set
    var greyBgColor by mutableStateOf(greyBgColor)
        private set
    var greyTextColor by mutableStateOf(greyTextColor)
        private set
    var disableButtonBg by mutableStateOf(disableButtonBg)
        private set
    var lightWhiteBgColor by mutableStateOf(lightWhiteBgColor)
        private set
    var lightGreyTextColor by mutableStateOf(lightGreyTextColor)
        private set
    var greyContainerColor by mutableStateOf(greyContainerColor)
        private set
    var greyBorderColor by mutableStateOf(greyBorderColor)
        private set
    var greyIconColor by mutableStateOf(greyIconColor)
        private set

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryVariant: Color = this.primaryVariant,
        background: Color = this.background,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryVariant: Color = this.secondaryVariant,
        surface: Color = this.colorSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        onSurface: Color = this.onSurface,
        greyBgColor: Color = this.greyBgColor,
        greyTextColor: Color = this.greyTextColor,
        disableButtonBg: Color = this.disableButtonBg,
        lightWhiteBgColor: Color = this.lightWhiteBgColor,
        lightGreyTextColor: Color = this.lightGreyTextColor,
        greyContainerColor: Color = this.greyContainerColor,
        greyBorderColor: Color = this.greyBorderColor,
        greyIconColor: Color = this.greyIconColor,
    ): AppColors = AppColors(
        primary,
        onPrimary,
        primaryVariant,
        background,
        secondary,
        onSecondary,
        secondaryVariant,
        surface,
        error,
        onError,
        onSurface,
        greyBgColor,
        greyTextColor,
        disableButtonBg,
        lightWhiteBgColor,
        lightGreyTextColor,
        greyContainerColor,
        greyBorderColor,
        greyIconColor,
    )
}

fun lightThemeColors(): AppColors {
    return getAppColors()
}

fun getAppColors(): AppColors = AppColors(
    colorPrimary,
    colorOnPrimary,
    colorPrimaryVariant,
    background,
    colorSecondary,
    colorOnSecondary,
    colorSecondaryVariant,
    colorSurface,
    colorError,
    colorOnError,
    colorOnSurface,
    greyBgColor,
    greyTextColor,
    disableButtonBg,
    lightWhiteBgColor,
    lightGreyTextColor,
    greyContainerColor,
    greyBorderColor,
    greyIconColor,
)

val LocalColors = staticCompositionLocalOf {
    lightThemeColors()
}