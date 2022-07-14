package com.xccv.moviedbapp.presentation.main
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xccv.moviedbapp.presentation.main.components.LottieMovieLoadingView

@Composable
@Preview
fun MainScreen() {

    Scaffold {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)

        ) {
            item { LottieMovieLoadingView() }

            item {
                    Text(
                        "You have successfully logged in. Stay tuned !",
                        Modifier.padding(16.dp),
                        textAlign = TextAlign.Center,
                        style = typography.h4,
                    )

            }

        }
    }

}
