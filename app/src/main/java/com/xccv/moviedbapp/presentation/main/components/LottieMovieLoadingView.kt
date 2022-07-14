package com.xccv.moviedbapp.presentation.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.xccv.moviedbapp.common.lottie.LottieLoadingView

@Composable
fun LottieMovieLoadingView() {
    LottieLoadingView(
        context = LocalContext.current,
        file = "movie.json",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
