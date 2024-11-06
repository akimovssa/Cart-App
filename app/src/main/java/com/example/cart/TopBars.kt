package com.example.cart

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private var productCount: String = "-"
private var productCountStr: String = "$productCount товаров"

@Preview
@Composable
fun HomeTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))
    ) {
        Column(modifier = Modifier.fillMaxSize().background(colorResource(R.color.green_yellow))) {  }

        Image(
            painter = painterResource(R.drawable.bg_type_2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(110.dp))
            Row(
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth(.9f)
                    .background(colorResource(R.color.space_grey), RoundedCornerShape(15.dp)),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.search),
                    contentDescription = null,
                    tint = colorResource(R.color.text_gray),
                    modifier = Modifier
                        .padding(13.dp, 0.dp, 0.dp, 0.dp)
                        .size(18.dp)
                )

                val textState = remember { mutableStateOf("") }
                OutlinedTextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    placeholder = {
                        Text(
                            text = "Поиск...",
                            color = colorResource(R.color.text_gray),
                            fontSize = 14.sp
                        ) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(.65f),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = colorResource(R.color.space_grey),
                        unfocusedTextColor = colorResource(R.color.text_gray)
                    )
                )

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp, 2.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.green_yellow)
                    ),
                    shape = RoundedCornerShape(13.dp)
                ) {
                    Text(
                        text = "Найти",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(R.color.space_grey),
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopBar() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    TopAppBar(
        colors = topAppBarColors(
            containerColor = colorResource(R.color.space_grey),
        ),
        title = {
            Row(
                modifier = Modifier
                    .padding(5.dp),

            ) {
                Text(
                    "Корзина",
                    maxLines = 1,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.text_white),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    productCountStr,
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.text_gray),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.share_cart),
                    contentDescription = "Поделиться",
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsCatalogTopBar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = colorResource(R.color.space_grey),
        ),
        title = {
            Text(
                "Каталог товаров",
                maxLines = 1,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.text_white),
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}