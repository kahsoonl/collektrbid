package com.example.bid.detail.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bid.detail.viewmodel.BidDetailUserIntent

@Composable
fun BidDetailInitialLoading(
    collectableId: Int,
    userIntent: (BidDetailUserIntent) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }

    LaunchedEffect(Unit) {
        userIntent.invoke(
            BidDetailUserIntent.FetchDetailData(
                collectableId = collectableId,
            )
        )
    }
}