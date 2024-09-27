package com.example.collektrbid.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.foundation.design.theme.AppTheme
import com.example.foundation.navigation.NavigationCommand

@Composable
fun AppBottomNavBar(
    bottomTabList: List<NavigationCommand>,
    currentDestination: NavDestination?,
    onNavigateTopLevelDestination: (NavigationCommand) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .height(64.dp)
            .shadow(16.dp),
        containerColor = Color.White,
    ) {
        Row {
            bottomTabList.forEach { destination ->
                val isSelected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (isSelected) {
                        HorizontalDivider(
                            color = AppTheme.colors.primary,
                            thickness = 3.dp,
                            modifier = Modifier
                                .width(70.dp),
                        )
                    }
                    this@NavigationBar.NavigationBarItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        icon = {},
                        selected = isSelected,
                        alwaysShowLabel = true,
                        onClick = { onNavigateTopLevelDestination(destination) },
                        label = {
                            Text(
                                text = stringResource(id = destination.label),
                                color = if (isSelected) AppTheme.colors.primary else Color.Black,
                            )
                        }
                    )
                }
            }
        }
    }
}