package com.example.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Category(
    val id: Int,
    val icon: Color,
    val name: String
)

@Composable
fun CategoryList() {
    val categories = listOf(
        Category(id = 1, icon = Color(0xFFFFA800), name = "Категория"),
        Category(id = 2, icon = Color(0xFF0500FF), name = "Категория"),
        Category(id = 3, icon = Color(0xFFC4F85C), name = "Категория"),
        Category(id = 3, icon = Color(0xFFF7F7F7), name = "Категория"),
        Category(id = 4, icon = Color(0xFFF7F7F7), name = "Категория"),
        Category(id = 5, icon = colorResource(R.color.green_yellow), name = "Категория"),
        Category(id = 6, icon = Color(0xFFC4F85C), name = "Категория"),
        Category(id = 7, icon = Color(0xFFF7F7F7), name = "Категория"),
        Category(id = 8, icon = Color(0xFFF7F7F7), name = "Категория"),
    )

    CategoriesListGrid(categories)
}

@Composable
fun CategoriesListGrid(categoriesList: List<Category>) {
    LazyHorizontalGrid(
        modifier = Modifier
            .height(120.dp),
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(20.dp, 10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(categoriesList) { category ->
            CategoriesListGridUI(category)
        }
    }
}

@Composable
fun CategoriesListGridUI(category: Category) {
    Column(
        modifier = Modifier
            .width(52.dp)
    ) {
        Column(
            modifier = Modifier
                .height(52.dp)
                .width(52.dp)
                .background(
                    color = category.icon,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {}

        Text(
            category.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            color = colorResource(R.color.text_white),
            style = TextStyle(
                lineHeight = 16.sp
            ),
            modifier = Modifier
                .padding(0.dp, 5.dp)
        )
    }
}

@Preview
@Composable
fun Prew() {
    CategoryList()
}