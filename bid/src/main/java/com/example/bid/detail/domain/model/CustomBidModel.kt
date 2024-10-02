package com.example.bid.detail.domain.model

import com.example.foundation.interaction.util.emptyValue

data class CustomBidModel(
    val customBidInput: String = String.emptyValue(),
    val showError: Boolean = true,
) {
    companion object {
        val emptyValue = CustomBidModel()
    }
}