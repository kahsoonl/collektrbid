package com.example.bid.detail.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.bid.R

@Composable
fun BidDetailCustomBidDialog(
    onDismiss: () -> Unit,
    onPositive: () -> Unit,
    onValueChange: (String) -> Unit,
    bidInputValue: String,
    showError: Boolean,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .clip(
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    Color.White,
                ),
        ) {
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = bidInputValue,
                onValueChange = onValueChange,
                label = {
                    Text(
                        text = stringResource(R.string.bid_custom_bid_label),
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.bid_custom_bid_label),
                        fontSize = 14.sp,
                        color = Color.Gray,
                    )
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send,
                    keyboardType = KeyboardType.Number,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                isError = showError,
            )
            if (showError) {
                Text(
                    text = stringResource(R.string.bid_custom_bid_hint),
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                        ),
                    color = Color.Red,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextButton(
                    onClick = { onDismiss() },
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(
                        text = stringResource(R.string.bid_dialog_negative_button_text)
                    )
                }
                TextButton(
                    onClick = { onPositive() },
                    modifier = Modifier.padding(8.dp),
                    enabled = !showError,
                ) {
                    Text(
                        text = stringResource(R.string.bid_dialog_positive_button_text)
                    )
                }
            }
        }
    }
}