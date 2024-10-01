package com.example.foundation.design.reusable_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.foundation.design.INTERACTABLE_SHAPE

@Composable
fun AppButtonWhite(
    buttonText: String,
    buttonModifier: Modifier = Modifier,
    onClickListener: () -> Unit,
    isEnabled: Boolean = true,
    borderColor: Color = Color.White,
    shape: Shape = INTERACTABLE_SHAPE,
    textModifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = Color.White,
    ),
) {
    Button(
        onClick = onClickListener,
        modifier = buttonModifier
            .semantics {
                contentDescription = "$buttonText button"
            },
        elevation = null,
        border = BorderStroke(
            width = 2.dp,
            color = borderColor,
        ),
        shape = shape,
        colors = colors,
        enabled = isEnabled,
    ) {
        Text(
            text = buttonText,
            modifier = textModifier
        )
    }
}
