package com.example.bid.overview.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bid.overview.viewmodel.BidOverviewUserIntent
import com.example.bid.overview.viewmodel.BidOverviewViewState

@Composable
fun BidOverviewDataLoaded(
    viewState: BidOverviewViewState.DataLoaded,
    userIntent: (BidOverviewUserIntent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize(),
    ) {
        itemsIndexed(viewState.collectableList) { index, item ->
            Text(item.collectableName)
        }
    }
}