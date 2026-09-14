package com.example.ioslauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IOSLauncher()
        }
    }
}

data class AppIcon(
    val name: String,
    val emoji: String
)

@Composable
fun IOSLauncher() {

    val apps = listOf(
        AppIcon("Telefon", "📞"),
        AppIcon("Üzenetek", "💬"),
        AppIcon("Kamera", "📷"),
        AppIcon("Fotók", "🌈"),
        AppIcon("Zene", "🎵"),
        AppIcon("Térképek", "🗺️"),
        AppIcon("Időjárás", "☀️"),
        AppIcon("Óra", "⏰"),
        AppIcon("Jegyzetek", "📝"),
        AppIcon("Naptár", "📅"),
        AppIcon("Beállítások", "⚙️"),
        AppIcon("App Store", "🛍️")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF6EC6FF),
                        Color(0xFF7B61FF),
                        Color(0xFFFF7AC8)
                    )
                )
            )
            .padding(horizontal = 18.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "21:31",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "▮▮▮  Wi-Fi  🔋",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                verticalArrangement = Arrangement.spacedBy(22.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {

                items(apps) { app ->
                    AppButton(app)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.White.copy(alpha = 0.25f))
                    .padding(12.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AppButton(AppIcon("Telefon", "📞"))
                    AppButton(AppIcon("Safari", "🧭"))
                    AppButton(AppIcon("Üzenetek", "💬"))
                    AppButton(AppIcon("Zene", "🎵"))
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "●  ○  ○",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun AppButton(app: AppIcon) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { }
    ) {

        Box(
            modifier = Modifier
                .size(58.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White.copy(alpha = 0.9f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = app.emoji,
                fontSize = 29.sp
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = app.name,
            color = Color.White,
            fontSize = 11.sp,
            maxLines = 1
        )
    }
}
