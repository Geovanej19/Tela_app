package com.example.exerccioapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerccioapp.ui.theme.ExercícioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercícioAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    PlayGameSrceen(
//                        modifier = Modifier.padding(innerPadding)
//                    )

                    GameoverSrceen(
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
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {

            // Status do jogo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // Score
                Text(
                    text = "SCORE: 0050",
                    color = Color.White
                )

                // Lives
                Row {

                    Text(
                        text = "LIVES:",
                        color = Color.White
                    )

                    repeat(3) {
                        AndroidEnemy(
                            color = Color.Green,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            }

            // Área principal do jogo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                // Inimigos
                EnemyRow(
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                // Jogador
                AndroidEnemy(
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.BottomCenter),
                    color = Color.Cyan
                )
            }

            // Botão PRESS START
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "PRESS START",
                    color = Color.White
                )
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
            colorFilter = ColorFilter.tint(color),
            contentDescription = "Android Enemy",
            modifier = modifier
        )
    }

    @Composable
    fun EnemyRow(
        modifier: Modifier = Modifier
    ) {

        val enemyColors = listOf(
            Color.Green,
            Color.Red,
            Color.Blue,
            Color.Yellow,
            Color.Green
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            enemyColors.forEach { color ->

                AndroidEnemy(
                    modifier = Modifier.size(50.dp),
                    color = color
                )
            }
        }
    }

    @Composable
    fun GameoverSrceen(
        modifier: Modifier = Modifier
    ) {

        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "GAME OVER",
                color = Color.White,
                fontSize = 60.sp,
                fontWeight = FontWeight.W700
            )
        }
    }
}
