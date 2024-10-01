package com.example.foundation.design.reusable_component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.example.foundation.design.INTERACTABLE_SHAPE
import com.example.foundation.design.theme.AppTheme

@Composable
fun AppButton(
    buttonText: String,
    buttonModifier: Modifier = Modifier,
    onClickListener: () -> Unit,
    isEnabled: Boolean,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = AppTheme.colors.primary,
        contentColor = AppTheme.colors.onPrimary
    ),
    shape: Shape = INTERACTABLE_SHAPE,
    textModifier: Modifier = Modifier,
) {
    Button(
        onClick = onClickListener,
        modifier = buttonModifier,
        elevation = null,
        shape = shape,
        enabled = isEnabled,
        colors = colors,
    ) {
        Text(
            modifier = textModifier,
            text = buttonText,
            color = if (isEnabled) AppTheme.colors.onPrimary else AppTheme.colors.greyTextColor,
        )
    }
}