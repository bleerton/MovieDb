package com.xccv.moviedbapp.presentation.login.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xccv.moviedbapp.common.lottie.LottieLoadingView

@Composable
fun LottieWorkingLoadingView(context: Context) {
    LottieLoadingView(
        context = context,
        file = "working.json",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
