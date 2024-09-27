package com.example.foundation.navigation.utility

import com.example.foundation.navigation.NavigationCommand

internal var bottomTabList = listOf<NavigationCommand>()

fun getBottomNavigationItems(): List<NavigationCommand> {
    bottomTabList = mutableListOf<NavigationCommand>()
        .apply {
            add(NavigationCommand.BidOverview)
            add(NavigationCommand.DeliveryEstimation)
            add(NavigationCommand.Offer)
        }
        .toList()
    return bottomTabList
}
