package com.example.bid.overview.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bid.R
import com.example.bid.overview.view.uicomponents.BidOverviewAppBar
import com.example.bid.overview.viewmodel.BidOverviewUserIntent
import com.example.bid.overview.viewmodel.BidOverviewViewState

@Composable
fun BidOverviewDataLoaded(
    viewState: BidOverviewViewState.DataLoaded,
    userIntent: (BidOverviewUserIntent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            BidOverviewAppBar()
        }
        item {
            Text(
                text = stringResource(R.string.bid_overview_on_going_bid),
                modifier = Modifier
                    .padding(
                        16.dp
                    ),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        }
        items(viewState.collectableList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .clip(
                        shape = CardDefaults.shape,
                    )
                    .clickable {
                        userIntent.invoke(BidOverviewUserIntent.CollectableOnClick(item.collectableId))
                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 8.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = item.collectableName,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(
                                R.string.bid_item_info_price,
                                item.collectableBids.last().bidAmount
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.summoned_skull_test),
                        contentDescription = "listing image",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
    }
}