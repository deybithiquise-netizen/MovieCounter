package com.example.moviecounter.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MovieRating(modifier: Modifier = Modifier) {
    var movieTitle by rememberSaveable { mutableStateOf("") }
    var rating by rememberSaveable { mutableStateOf(0) }
    var totalRatedMovies by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Movie Rating App",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "You have rated $totalRatedMovies movies.")

        TextField(
            value = movieTitle,
            onValueChange = { movieTitle = it },
            label = { Text("Movie Title") },
            placeholder = { Text("Enter movie name...") }
        )

        Text(text = "Rating: $rating/5 stars")

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 1..5) {
                Button(
                    onClick = { rating = i },
                    colors = if (i <= rating) {
                        ButtonDefaults.buttonColors()
                    } else {
                        ButtonDefaults.outlinedButtonColors()
                    }
                ) {
                    Text("$i")
                }
            }
        }

        Button(
            onClick = {
                if (movieTitle.isNotBlank() && rating > 0) {
                    totalRatedMovies++
                    movieTitle = ""
                    rating = 0
                }
            },
            enabled = movieTitle.isNotBlank() && rating > 0
        ) {
            Text("Rate Movie")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieRating() {
    MovieRating()
}