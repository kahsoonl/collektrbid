package com.example.bid.overview.view.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bid.R
import com.example.foundation.design.theme.AppTheme

@Composable
fun BidOverviewAppBar() {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 16.dp,
                shape = RectangleShape,
            )
            .background(
                color = AppTheme.colors.primary,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.bid_overview_title),
            modifier = Modifier
                .padding(
                    16.dp,
                ),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}