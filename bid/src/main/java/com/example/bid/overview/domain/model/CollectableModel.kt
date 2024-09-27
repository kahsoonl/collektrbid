package com.example.bid.overview.domain.model

import com.example.bid.detail.domain.model.BidModel
import com.example.foundation.interaction.util.emptyValue

data class CollectableModel(
    val collectableId: Int = Int.emptyValue(),
    val collectableName: String = String.emptyValue(),
    val collectableDesc: String = String.emptyValue(),
    val collectableBids: List<BidModel> = emptyList(),
)