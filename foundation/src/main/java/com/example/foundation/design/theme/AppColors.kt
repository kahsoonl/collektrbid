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

val colorLightBlue = Color(0xffE5FDFF)
val colorDarkBlue = Color(0xff396E75)
val colorWhite30 = Color(0x4DFFFFFF)
val textColorLink = Color(0xff38539A)
val amwayBlack = Color(0xff2C2C2C)
val darkGrayOnWhite = Color(0xff707070)
val textBlueColor = Color(0xff5D7DD0)
val greyTextColor = Color(0xff6F6B6D)
val greyBgColor = Color(0xffE5E5E5)
val greyContainerColor = Color(0xFFFBFBFB)
val greyBorderColor = Color(0xFFEFEFEF)
val greyIconColor = Color(0xFF9B9B9B)
val lightGreyTextColor = Color(0xff9B9B9B)
val greyCardBgColor = Color(0xFFD6D6D6)
val greyProfileBgColor = Color(0xfff0f0f0)
val lightWhiteBgColor = Color(0xffFAFAFA)
val progressLoadingColor = Color(0xff94A3CD)
val disableButtonBg = Color(0xffD9D9D9)
val lightPurpleColor = Color(0xffF1F2FF)
val lightGreyBgColor = Color(0xB2707070)
val lighterGreyBgColor = Color(0xB3707070)
val darkPurple = Color(0xff38539A)
val businessNameTagColor = Color(0xff38539A)
val blackScrim = Color(0f, 0f, 0f, 0.01f)
val whiteScrim = Color(1f, 1f, 1f, 0.76f)
val errorRed = Color(0xffD91734)
val lightOrange = Color(0xffFFF1E8)
val darkOrange = Color(0xffA36A00)
val vizAlertOrange = Color(0xffDA7600)
val darkBlue = Color(0xff183276)
val colorDarkGreen = Color(0xff546223)
val lightGreySmallBG = Color(0xffF4F4F4)
val midGreyOnBlack = Color(0xff949494)
val black80Alpha = Color(0xCC000000)
val shadowColor = Color(0x1A2C2C2C)
val errorRedBorder = Color(0xFFEB8593)
val errorRedBackgroundGradient = Color(0xFFFDF4F4)
val successGreen = Color(0xff107F47)
val successGreenBorder = Color(0xff7FBC96)
val successGreenGradient = Color(0xffF0FAE5)
val tooltipColor = Color(0xffC9A76E)
val amwayGTPageIndicator = Color(0x66FFFFFF)
val amwayGTPageIndicator2 = Color(0x44D6D6D6)
val amwayGTPageIndicatorText = Color(0x66D6D6D6)
val translucentButtonBackground = Color(0xC7F9F9F9)
val buttonLinkColor = Color(0xFF007AFF)
val bottomSheetDivider = Color(0xffE4E4E4)
val alertOrange = Color(0xffA66400)
val warningYellow = Color(0xffD1B278)
val alertLightOrange = Color(0xffFFF9F0)
val disabledGrayOn = Color(0xff5E5E5E)
val facebookBlue = Color(0xff0866FF)
val hotLeadColor = Color(0xff7F3E3E)
val warmLeadColor = Color(0xffA65523)
val coldLeadColor = Color(0xff396E75)
val darkOrangeBorder = Color(0xffA65523)
val darkRed = Color(0xff7F3E3E)
val lightRed = Color(0xffFFE2E2)
val beigeChipBgColor = Color(0xFFF0EEE7)
val beigeLabelColor = Color(0xFF8E845B)
val redBackgroundColor = Color(0xFFFCE8E6)
val redBorderColor = Color(0xFFEC5A49)
val pinkAccentColor = Color(0xFFFFE1E2)
val successGreenColor = Color(0xFF14B823)
val availabilityBeigeBgColor = Color(0xFFF7F6F3)
val availabilityBeigeAccentColor = Color(0xFFD6CCA3)

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
    facebookBlue: Color,
    lightGreyTextColor: Color,
    greyContainerColor: Color,
    greyBorderColor: Color,
    greyIconColor: Color,
    beigeChipColor: Color,
    beigeLabelColor: Color,
    redBackGroundColor: Color,
    redBorderColor: Color,
    pinkAccentColor: Color,
    successGreenColor: Color,
    buttonLinkColor: Color,
    availabilityBeigeBgColor: Color,
    availabilityBeigeAccentColor: Color,
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
    var facebookBlue by mutableStateOf(facebookBlue)
        private set
    var lightGreyTextColor by mutableStateOf(lightGreyTextColor)
        private set
    var greyContainerColor by mutableStateOf(greyContainerColor)
        private set
    var greyBorderColor by mutableStateOf(greyBorderColor)
        private set
    var beigeChipColor by mutableStateOf(beigeChipColor)
        private set
    var beigeLabelColor by mutableStateOf(beigeLabelColor)
        private set
    var greyIconColor by mutableStateOf(greyIconColor)
        private set
    var redBackGroundColor by mutableStateOf(redBackGroundColor)
        private set
    var redBorderColor by mutableStateOf(redBorderColor)
        private set
    var pinkAccentColor by mutableStateOf(pinkAccentColor)
        private set
    var successGreenColor by mutableStateOf(successGreenColor)
        private set
    var buttonLinkColor by mutableStateOf(buttonLinkColor)
        private set
    var availabilityBgBeigeColor by mutableStateOf(availabilityBeigeBgColor)
        private set
    var availabilityBeigeAccentColor by mutableStateOf(availabilityBeigeAccentColor)
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
        facebookBlue: Color = this.facebookBlue,
        lightGreyTextColor: Color = this.lightGreyTextColor,
        greyContainerColor: Color = this.greyContainerColor,
        greyBorderColor: Color = this.greyBorderColor,
        greyIconColor: Color = this.greyIconColor,
        beigeChipColor: Color = this.beigeChipColor,
        beigeLabelColor: Color = this.beigeLabelColor,
        redBackGroundColor: Color = this.redBackGroundColor,
        redBorderColor: Color = this.redBorderColor,
        pinkAccentColor: Color = this.pinkAccentColor,
        successGreenColor: Color = this.successGreenColor,
        buttonLinkColor: Color = this.buttonLinkColor,
        availabilityBeigeBgColor: Color = this.availabilityBgBeigeColor,
        availabilityBeigeAccentColor: Color = this.availabilityBeigeAccentColor,
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
        facebookBlue,
        lightGreyTextColor,
        greyContainerColor,
        greyBorderColor,
        greyIconColor,
        beigeChipColor,
        beigeLabelColor,
        redBackGroundColor,
        redBorderColor,
        pinkAccentColor,
        successGreenColor,
        buttonLinkColor,
        availabilityBeigeBgColor,
        availabilityBeigeAccentColor,
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
    facebookBlue,
    lightGreyTextColor,
    greyContainerColor,
    greyBorderColor,
    greyIconColor,
    beigeChipBgColor,
    beigeLabelColor,
    redBackgroundColor,
    redBorderColor,
    pinkAccentColor,
    successGreenColor,
    buttonLinkColor,
    availabilityBeigeBgColor,
    availabilityBeigeAccentColor,
)

val LocalColors = staticCompositionLocalOf {
    lightThemeColors()
}