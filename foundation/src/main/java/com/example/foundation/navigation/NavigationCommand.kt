package com.example.foundation.navigation

import androidx.navigation.NamedNavArgument
import com.example.foundation.navigation.utility.createArgument
import java.io.Serializable

val initialNavCommand = NavigationCommand.BidOverview

sealed class NavigationCommand(
    var route: String,
    var destination: String,
    var arguments: List<NamedNavArgument> = emptyList(),
) : Serializable {
    companion object {
        // PopBackStack
        private const val PopBackStackRoute = "popBackStack_route"

        // Bid Overview
        const val BidOverviewRoute = "bid_overview_route"
        const val BidOverviewDestination = "bid_overview_destination"

        // Bid Detail
        const val BidDetailRoute = "bid_detail_route"
        const val BidDetailDestination = "bid_detail_destination"
        const val BidDetailCollectableIdArgs = "bid_detail_collectable_id_args"
    }

    data object None : NavigationCommand(route = "", destination = "")

    data object PopBackStack : NavigationCommand(route = PopBackStackRoute, destination = "")

    data object BidOverview : NavigationCommand(
        route = BidOverviewRoute,
        destination = BidOverviewDestination,
    )

    data object BidDetail : NavigationCommand(
        route = BidDetailRoute,
        destination = BidDetailDestination,
        arguments = createArgument(BidDetailRoute)
    )
}
