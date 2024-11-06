package com.example.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

data class BannerItem(
    val id: Int,
    val imageRes: Int
)

@Preview
@Composable
fun Banner() {
    val banners = listOf(
        BannerItem(1, R.drawable.nnn_white),
        BannerItem(2, R.drawable.banner_img_1),
        BannerItem(3, R.drawable.nnn_white)
    )

    var currentIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        while (true) {
            delay(7000)
            currentIndex = (currentIndex + 1) % banners.size
            listState.animateScrollToItem(currentIndex)
        }
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        state = listState
    ) {
        items(banners) { banner ->
            Image(
                painter = painterResource(banner.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
            )
        }
    }
}
