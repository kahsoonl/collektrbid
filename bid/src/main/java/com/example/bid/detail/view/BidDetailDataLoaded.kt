package com.example.bid.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bid.detail.viewmodel.BidDetailUserIntent
import com.example.bid.detail.viewmodel.BidDetailViewState

@Composable
fun BidDetailDataLoaded(
    viewState: BidDetailViewState.DataLoaded,
    userIntent: (BidDetailUserIntent) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize(),
    ) {
        Text(
            text = viewState.collectableModel.collectableName,
        )
    }
}