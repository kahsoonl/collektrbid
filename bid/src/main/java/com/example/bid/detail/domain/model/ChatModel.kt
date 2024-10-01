package com.example.bid.detail.domain.model

import com.example.foundation.interaction.util.emptyValue

class ChatModel(
    val posterName: String = String.emptyValue(),
    val message: String = String.emptyValue(),
    val postedDateTime: String = String.emptyValue(),
) {
    companion object {
        val dummyData = listOf(
            ChatModel(
                posterName = "MohammadAli",
                message = "This is sick!",
            ),
            ChatModel(
                posterName = "TheWiseMagician42",
                message = "Is this unopened?",
            ),
            ChatModel(
                posterName = "GreatestTrickEver",
                message = "Wow! This look awesome",
            ),
            ChatModel(
                posterName = "StrangerThings12",
                message = "Hmm this looks interesting..",
            ),
            ChatModel(
                posterName = "thelegends62",
                message = "Looks good but not as good as mine! All the best selling",
            ),
            ChatModel(
                posterName = "hoarder404",
                message = "This would look good on my collection!",
            ),
        )
    }
}