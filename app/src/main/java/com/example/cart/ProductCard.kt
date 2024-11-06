package com.example.cart

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ProductCard(
    val id : Int,
    val image: Int,
    val currentPrice: Double,
    val oldPrice: Double,
    val brandName: String,
    val description: String,
    val color: String,
    val size: String,
    val rating: Double,
    val feedbacksCount: Int
)

val products = listOf(
    ProductCard(1, R.drawable.nnn_black, 1594.00, 2181.00, "Название бренда", "Lorem ipsum odor amet, consectetuer adipiscing elit. Dolor phasellus turpis elementum curae purus phasellus? Ultrices senectus dignissim taciti ultrices inceptos fermentum risus. Ornare elit parturient dignissim a per diam.", "Белый", "L", 4.7, 820),
    ProductCard(2, R.drawable.nnn_white, 1720.00, 2150.00, "Название бренда", "Lorem ipsum odor amet, consectetuer adipiscing elit. Dolor phasellus turpis elementum curae purus phasellus? Ultrices senectus dignissim taciti ultrices inceptos fermentum risus. Ornare elit parturient dignissim a per diam.", "Бело/синий", "M", 4.9, 127),
    ProductCard(3, R.drawable.nnn_white, 2298.00, 3569.00, "Название бренда", "Lorem ipsum odor amet, consectetuer adipiscing elit. Dolor phasellus turpis elementum curae purus phasellus? Ultrices senectus dignissim taciti ultrices inceptos fermentum risus. Ornare elit parturient dignissim a per diam.", "Ч/Б", "XL", 3.8, 56),
    ProductCard(4, R.drawable.nnn_black, 2120.00, 2715.00, "Название бренда", "Lorem ipsum odor amet, consectetuer adipiscing elit. Dolor phasellus turpis elementum curae purus phasellus? Ultrices senectus dignissim taciti ultrices inceptos fermentum risus. Ornare elit parturient dignissim a per diam.", "Черный", "S", 4.2, 120)
)

@Composable
fun ProductCardGrid(productCards: List<ProductCard>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items(productCards) { product ->
            CardItemInSearch(product)
        }
    }
}

@Composable
fun ProductCardGridInCart(productCards: List<ProductCard>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items(productCards) { product ->
            CardItemInCart(product)
        }
    }
}

@Composable
fun CardItemInSearch(product: ProductCard) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(R.color.black_bg)),
        ) {
            Box(
                modifier = Modifier
                    .height(230.dp)
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(20.dp)
                    ),
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(10.dp, 5.dp, 10.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        "${product.currentPrice} ₽",
                        fontSize = 18.sp,
                        maxLines = 1,
                        fontWeight = FontWeight.W700,
                        color = colorResource(R.color.green_yellow),
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        "${product.oldPrice} ₽",
                        fontSize = 16.sp,
                        maxLines = 1,
                        color = colorResource(R.color.text_gray),
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            textDecoration = TextDecoration.LineThrough
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        product.brandName,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.text_white)
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        product.description,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.text_white)
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(0.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.rating_star),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp)
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            "${product.rating}",
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_white)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .width(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "•",
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_gray),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "${product.feedbacksCount} отзывов",
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_gray)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(0.dp))

                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.green_yellow)),
                        shape = RoundedCornerShape(10.dp),
                        onClick = { Toast.makeText(context, "ID товара: ${product.id}", Toast.LENGTH_SHORT).show() }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.add_to_cart),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                "Добавить",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W600,
                                color = colorResource(R.color.black_bg)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardItemInCart(product: ProductCard) {
    val context = LocalContext.current
    var counter by remember { mutableIntStateOf(1) }

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.space_grey))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(17.dp, 17.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(125.dp)
                        .fillMaxHeight()
                ) {
                    Column(
                        modifier = Modifier
                            .height(170.dp)
                            .background(
                                color = colorResource(R.color.white),
                                shape = RoundedCornerShape(16.dp)
                            ),
                    ) {
                        Image(
                            painter = painterResource(id = product.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .width(225.dp)
                        .fillMaxHeight()
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "${product.currentPrice} ₽",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W700,
                            maxLines = 1,
                            color = colorResource(R.color.green_yellow),
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            "${product.oldPrice} ₽",
                            fontSize = 16.sp,
                            maxLines = 1,
                            color = colorResource(R.color.text_gray),
                            style = TextStyle(
                                textDecoration = TextDecoration.LineThrough
                            ),
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(0.dp))

                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Бренд: ",
                            maxLines = 1,
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_gray),
                        )

                        Text(
                            product.brandName,
                            maxLines = 1,
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_white),
                        )
                    }

                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            product.description,
                            maxLines = 2,
                            fontSize = 14.sp,
                            overflow = TextOverflow.Ellipsis,
                            color = colorResource(R.color.text_white)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Цвет: ",
                            maxLines = 1,
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_gray),
                        )

                        Text(
                            product.color,
                            maxLines = 1,
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_white),
                        )
                    }

                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Размер: ",
                            maxLines = 1,
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_gray),
                        )

                        Text(
                            product.size,
                            maxLines = 1,
                            fontSize = 14.sp,
                            color = colorResource(R.color.text_white),
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxSize()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Box(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxSize(.55f)
                                .align(Alignment.TopStart)
                                .background(
                                    color = colorResource(R.color.light_grey_2),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            IconButton(
                                onClick = {
                                    if (counter > 1) counter--
                                },
                                enabled = counter > 1,
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.minus),
                                    contentDescription = null,
                                    tint = if (counter > 1) colorResource(R.color.text_white) else colorResource(R.color.text_gray),
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                            }

                            Text(
                                counter.toString(),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                                color = colorResource(R.color.text_white),
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )

                            IconButton(
                                onClick = {
                                    if (counter < 99) counter++
                                },
                                enabled = counter < 99,
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.plus),
                                    contentDescription = null,
                                    tint = if (counter < 99) colorResource(R.color.text_white) else colorResource(R.color.text_gray),
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                            }
                        }

                        IconButton(
                            onClick = { Toast.makeText(context, "Вы купили товар под id: ${product.id}", Toast.LENGTH_SHORT).show() },
                            enabled = true,
                            modifier = Modifier
                                .fillMaxSize(.4f)
                                .align(Alignment.CenterEnd)
                                .background(colorResource(R.color.green_yellow), RoundedCornerShape(16.dp))
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.pay),
                                tint = colorResource(R.color.black_bg),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(26.dp)
                            )
                        }

//                        OutlinedButton(
//                            onClick = { Toast.makeText(context, "Вы купили товар под id: ${product.id}", Toast.LENGTH_SHORT).show() },
//                            modifier = Modifier
//                                .wrapContentHeight(),
//                            border = BorderStroke(1.dp, color = colorResource(R.color.green_yellow)),
//                            shape = RoundedCornerShape(33)
//                        ) {
//                            Text(
//                                "Купить",
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.W600,
//                                color = colorResource(R.color.green_yellow)
//                            )
//                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PrevCards() {
    ProductCardGrid(productCards = products)
}