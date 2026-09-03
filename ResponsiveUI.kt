package com.cse226.application.CA1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

class ResponsiveUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiveNewsCard(
                imageUrl = "https://picsum.photos/400/300",
                title = "Breaking News: Compose is fun",
                rememberAsyncImagePainter = TODO(),
            )
        }
    }
}

@Composable
fun ResponsiveNewsCard(
    imageUrl: String,
    title: String,
    rememberAsyncImagePainter: (String) -> Painter
) {
    BoxWithConstraints(Modifier.fillMaxWidth().padding(8.dp)) {
        val w = maxWidth

        if (w < 360.dp) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(120.dp)
                )
                Text(title)
                Row {
                    Button(onClick = {}) { Text("Like") }
                    Button(onClick = {}) { Text("Share") }
                }
            }
        } else if (w < 600.dp) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(140.dp)
                )
                Row {
                    Text(title, modifier = Modifier.weight(1f))
                    Button(onClick = {}) { Text("Like") }
                    Button(onClick = {}) { Text("Share") }
                }
            }
        } else {
            Row {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier.weight(0.4f).height(160.dp)
                )
                Column(modifier = Modifier.weight(0.6f)) {
                    Text(title)
                    Row {
                        Button(onClick = {}) { Text("Like") }
                        Button(onClick = {}) { Text("Share") }
                    }
                }
            }
        }
    }
}