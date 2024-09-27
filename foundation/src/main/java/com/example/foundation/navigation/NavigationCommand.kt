package com.example.foundation.navigation

import androidx.annotation.StringRes
import com.example.mycourier.R
import java.io.Serializable

val initialNavCommand = NavigationCommand.BidOverview

sealed class NavigationCommand(
    var route: String,
    var destination: String,
    @StringRes var label: Int = 0,
) : Serializable {
    companion object {
        // PopBackStack
        private const val PopBackStackRoute = "popBackStack_route"

        // Cost
        const val BidOverviewRoute = "bid_overview_route"
        const val BidOverviewDestination = "bid_overview_destination"
    }

    data object None : NavigationCommand(route = "", destination = "")

    data object PopBackStack : NavigationCommand(route = PopBackStackRoute, destination = "")

    data object BidOverview : NavigationCommand(
        route = BidOverviewRoute,
        destination = BidOverviewDestination,
        label = R.string.bid_overview,
    )
}
