package com.example.cart

import android.widget.Toast
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Search : Routes("search")
    object Cart : Routes("cart")
    object Profile : Routes("profile")
}

@Composable
fun BottomBar(navController: NavController, isCart: Boolean = false) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp
                    )
                )
                .background(color = colorResource(R.color.light_grey))
        ) {
            if (isCart) {
                FloatingActionButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp, 8.dp),
                    onClick = { Toast.makeText(navController.context, Routes.Cart.route, Toast.LENGTH_SHORT).show() },
                    containerColor = colorResource(R.color.green_yellow),
                    shape = RoundedCornerShape(33),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "К оформлению",
                            maxLines = 1,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                            color = colorResource(R.color.black_bg)
                        )
                        Text(
                            "- шт., - ₽",
                            maxLines = 1,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = colorResource(R.color.black_bg)
                        )
                    }
                }
            }
        }
        BottomAppBar(
            modifier = Modifier
                .fillMaxHeight(.1f),
            containerColor = colorResource(R.color.space_grey),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 0.dp),
            actions = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate(Routes.Home.route) {
                                launchSingleTop = false
                            }
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.home),
                            contentDescription = "Главная",
                            tint = colorResource(R.color.icon_color),
                            modifier = Modifier
                                .size(22.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            navController.navigate(Routes.Search.route) {
                                popUpTo(Routes.Home.route)
                                launchSingleTop = true
                            }
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.search),
                            contentDescription = "Поиск",
                            tint = colorResource(R.color.icon_color),
                            modifier = Modifier
                                .size(22.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            navController.navigate(Routes.Cart.route) {
                                popUpTo(Routes.Home.route)
                                launchSingleTop = true
                            }
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.cart),
                            contentDescription = "Корзина",
                            tint = colorResource(R.color.text_gray),
                            modifier = Modifier
                                .size(22.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp, 5.dp),
                            contentAlignment = Alignment.TopEnd
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(0.35f)
                                    .clip(
                                        RoundedCornerShape(50)
                                    )
                                    .background(color = colorResource(R.color.push_red)),
                            ) {
                                Text(
                                    "",
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(0.dp, 0.dp),
                                    maxLines = 1,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W500,
                                    color = colorResource(R.color.text_white),
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                    IconButton(
                        onClick = {
                            navController.navigate(Routes.Profile.route) {
                                popUpTo(Routes.Home.route)
                                launchSingleTop = true
                            }
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.profile),
                            contentDescription = "Профиль",
                            tint = colorResource(R.color.icon_color),
                            modifier = Modifier
                                .size(22.dp),
                        )
                    }
                }
            }
        )
    }
}

fun scaleIntoContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.INWARDS,
    initialScale: Float = if (direction == ScaleTransitionDirection.OUTWARDS) 0.1f else 1.1f
): EnterTransition {
    return scaleIn(
        animationSpec = tween(220, delayMillis = 90),
        initialScale = initialScale
    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
}

fun scaleOutOfContainer(
    direction: ScaleTransitionDirection = ScaleTransitionDirection.OUTWARDS,
    targetScale: Float = if (direction == ScaleTransitionDirection.INWARDS) 0.1f else 1.1f
): ExitTransition {
    return scaleOut(
        animationSpec = tween(
            durationMillis = 220,
            delayMillis = 90
        ), targetScale = targetScale
    ) + fadeOut(tween(delayMillis = 90))
}

enum class ScaleTransitionDirection {
    INWARDS,
    OUTWARDS
}
