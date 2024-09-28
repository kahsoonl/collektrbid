package com.example.bid.detail.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bid.detail.viewmodel.BidDetailUserIntent

@Composable
fun BidDetailInitialLoading(
    collectableId: Int,
    userIntent: (BidDetailUserIntent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
    ) {

    }

    LaunchedEffect(Unit) {
        userIntent.invoke(
            BidDetailUserIntent.FetchDetailData(
                collectableId = collectableId,
            )
        )
    }
}