package com.example.bid.detail.domain.model

import com.example.foundation.interaction.util.emptyValue

data class BidModel(
    val bidId: Int = Int.emptyValue(),
    val collectableId: Int = Int.emptyValue(),
    val userName: String = String.emptyValue(),
    val bidAmount: Int = Int.emptyValue(),
    val bidDateTime: String = String.emptyValue(),
)