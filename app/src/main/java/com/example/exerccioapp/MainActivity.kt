package com.example.exerccioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.exerccioapp.ui.theme.ExercícioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercícioAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PlayGameSrceen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun PlayGameSrceen(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier.fillMaxSize()
                .background(Color.Black)
        ) {

            //Status Jogo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Score
                Text(
                    text = "SCORE: 0050",
                    color = Color.White
                )

                //lives
                Row() {
                    Text(
                        text = "lIVES:",
                        color = Color.White
                    )

                    repeat(3) {
                    }
                }

            }
        }
    }

    @Composable
    fun AndroidEnemy(
        modifier: Modifier = Modifier,
        color: Color
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            colorFilter = ColorFilter.tint(color = color),
            contentDescription = "Android Enemy",
            modifier = modifier
        )
    }
}

