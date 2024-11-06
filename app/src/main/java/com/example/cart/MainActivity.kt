package com.example.cart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cart.ui.theme.CartTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartTheme {
                App()
            }
        }
    }
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            val currentBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry.value?.destination?.route

            if (currentRoute == Routes.Cart.route) {
                CartTopBar()
            }
//            } else if (currentRoute == Routes.Home.route) {
//                ProductsCatalogTopBar()
//            }
        },
        bottomBar = {
            val currentBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry.value?.destination?.route

            BottomBar(
                navController = navController,
                isCart = currentRoute == Routes.Cart.route
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.black_bg))
                .padding(innerPadding))
        {
            NavHost(
                navController = navController,
                startDestination = Routes.Home.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(
                    Routes.Home.route,
                    enterTransition = {
                        slideIntoContainer()
                    },
                    exitTransition = {
                        slideOutOfContainer()
                    }
                ) {
                    HomeScreen()
                }
                composable(
                    Routes.Search.route,
                    enterTransition = {
                        slideIntoContainer()
                    },
                    exitTransition = {
                        slideOutOfContainer()
                    }
                ) {
                    SearchScreen()
                }
                composable(
                    Routes.Cart.route,
                    enterTransition = {
                        slideIntoContainer()
                    },
                    exitTransition = {
                        slideOutOfContainer()
                    }
                ) {
                    CartScreen()
                }
                composable(
                    Routes.Profile.route,
                    enterTransition = {
                        slideIntoContainer()
                    },
                    exitTransition = {
                        slideOutOfContainer()
                    }
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

fun slideIntoContainer(
    direction: SlideDirection = SlideDirection.LEFT,
    offset: Int = 1000
): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { if (direction == SlideDirection.RIGHT) -offset else offset },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
}

fun slideOutOfContainer(
    direction: SlideDirection = SlideDirection.RIGHT,
    offset: Int = 1000
): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { if (direction == SlideDirection.LEFT) -offset else offset },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
}

enum class SlideDirection {
    LEFT,
    RIGHT
}