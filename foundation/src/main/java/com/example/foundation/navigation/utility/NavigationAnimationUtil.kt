package com.example.foundation.navigation.utility

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry

fun <T> animationSpecCustom() = tween<T>(
    durationMillis = 300,
    easing = FastOutSlowInEasing, // interpolator
)

@ExperimentalAnimationApi
fun AnimatedContentTransitionScope<*>.defaultEnterTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): EnterTransition {
    val initialNavGraph = initial.destination.parent
    val targetNavGraph = target.destination.parent
    if (initialNavGraph?.id != targetNavGraph?.id) {
        return fadeIn()
    }
    return slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Start,
        animationSpec = animationSpecCustom(),
    )
}

@ExperimentalAnimationApi
fun AnimatedContentTransitionScope<*>.defaultExitTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): ExitTransition {
    val initialNavGraph = initial.destination.parent
    val targetNavGraph = target.destination.parent
    if (initialNavGraph?.id != targetNavGraph?.id) {
        return fadeOut()
    }
    // Otherwise, we're in the same nav graph; we can imply a direction.
    return slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Start,
        animationSpec = animationSpecCustom(),
    )
}

@ExperimentalAnimationApi
fun AnimatedContentTransitionScope<*>.defaultPopEnterTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): EnterTransition {
    val initialNavGraph = initial.destination.parent
    val targetNavGraph = target.destination.parent
    if (initialNavGraph?.id != targetNavGraph?.id) {
        return fadeIn()
    }
    return slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.End,
        animationSpec = animationSpecCustom(),
    )
}

@ExperimentalAnimationApi
fun AnimatedContentTransitionScope<*>.defaultPopExitTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): ExitTransition {
    val initialNavGraph = initial.destination.parent
    val targetNavGraph = target.destination.parent
    if (initialNavGraph?.id != targetNavGraph?.id) {
        return fadeOut()
    }
    return slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.End,
        animationSpec = animationSpecCustom(),
    )
}
