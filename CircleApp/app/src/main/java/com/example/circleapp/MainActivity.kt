package com.example.circleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.circleapp.ui.theme.CircleAppTheme
import kotlin.math.PI
import kotlin.math.pow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CircleAppTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    AreaFinder()
                }
            }
        }
    }
}

@Composable
fun Circle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(150.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(120.dp)) {
            val radius = 60.dp.toPx()
            val center = Offset(size.width / 2, size.height / 2)

            drawCircle(
                color = Color.Blue,
                center = center,
                radius = radius
            )

            drawLine(
                color = Color.White,
                start = center,
                end = Offset(center.x + radius, center.y)
            )
        }

        Text(
            text = "r",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .offset(x = 25.dp, y = 5.dp)
        )
    }
}

@Composable
fun AreaFinder() {
    var radius by remember { mutableStateOf("") }
    var resultA by remember { mutableStateOf("Area: 0.0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Circle(modifier = Modifier.padding(top = 24.dp))

        Text(
            text = "Formula = π r\u00B2",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = radius,
            onValueChange = { newValue ->
                radius = newValue
                resultA = "Area: 0.0"
            },
            label = { Text("Enter Circle Radius") },
            placeholder = { Text("e.g., 5.0") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                val radius = radius.toDoubleOrNull()

                if (radius == null || radius <= 0) {
                    resultA = "Please enter a positive number."
                } else {
                    val area = PI * radius.pow(2)
                    val formattedArea = String.format("%.2f", area)
                    resultA = "Area: $formattedArea"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Area")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = resultA,
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium
        )


    }
}

@Preview(showBackground = true)
@Composable
fun AreaFinderPreview() {
    CircleAppTheme {
        AreaFinder()
    }
}