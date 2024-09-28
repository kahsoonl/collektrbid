package com.example.foundation.navigation.utility

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.foundation.interaction.util.emptyValue
import com.example.foundation.navigation.NavigationCommand
import com.example.foundation.navigation.NavigationCommand.Companion.BidDetailCollectableIdArgs

fun createArgument(route: String): List<NamedNavArgument> {
    return when (route) {
        NavigationCommand.BidDetailRoute -> {
            listOf(
                navArgument(BidDetailCollectableIdArgs) {
                    type = NavType.IntType
                    defaultValue = Int.emptyValue()
                }
            )
        }

        else -> emptyList()
    }
}