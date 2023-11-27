package com.josecaballero.quoteswithpicture.feature.main.presentation.shared

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalViewPagerExample() {
    val pages = 10
    val state = rememberPagerState(initialPage = 0)

    VerticalPager(pageCount = pages, state = state) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Page: ${state.currentPage}")
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoopingVerticalPager(pages: Int) {
    val pagerState = rememberPagerState(initialPage = 0)

    VerticalPager(
        pageCount = pages,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Page: ${pagerState.currentPage + 1}",
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage == pages - 1) {
            // Reset to the first page when the last page is reached
            pagerState.scrollToPage(0)
        }
    }
}

// Usage
@Composable
fun LoopingVerticalPagerExample() {
    val totalPages = 5 // Set the total number of pages

    LoopingVerticalPager(pages = totalPages)
}








