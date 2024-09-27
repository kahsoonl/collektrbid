package com.example.bid.overview.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bid.overview.viewmodel.BidOverviewUserIntent

@Composable
fun BidOverviewInitialLoading(
    userIntent: (BidOverviewUserIntent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
    ) {

    }

    LaunchedEffect(Unit) {
        userIntent.invoke(BidOverviewUserIntent.FetchCollectableData)
    }
}