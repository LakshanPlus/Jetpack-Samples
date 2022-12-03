package com.example.ktalksample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktalksample.ui.theme.KtalkSampleTheme

class DrawTextCanvas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtalkSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExampleTextAnnotatedString()
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun MyCenterTextInCanvas() {
    val width: Dp = 200.dp
    val height: Dp = 40.dp
    val textMeasurer = rememberTextMeasurer()
    Canvas(
        modifier = Modifier
            .background(Color.LightGray)
            .wrapContentSize(
                align = Alignment.Center,
            )
            .requiredSize(
                width = width,
                height = height,
            ),
    ) {
        drawText(
            textMeasurer = textMeasurer,
            text = "Sample Text",
            topLeft = Offset(
                x = (width / 2).toPx(),
                y = (height / 2).toPx(),
            ),
        )
    }
}


@OptIn(ExperimentalTextApi::class)
@Composable
fun ExampleTextAnnotatedString() {

    val textMeasure = rememberTextMeasurer()

    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic
            )
        ) {
            append("Hello,")
        }
        withStyle(
            style = SpanStyle(
                brush = Brush.horizontalGradient(colors = RainbowColors),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("\nText on Canvas️")
        }
    }
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp), onDraw = {
        drawRect(color = Color.Black)

        drawText(
            textMeasurer = textMeasure,
            text = text,
            topLeft = Offset(10.dp.toPx(), 10.dp.toPx())
        )
    })
}

private val RainbowColors = listOf(
    Color(0xff9c4f96),
    Color(0xffff6355),
    Color(0xfffba949),
    Color(0xfffae442),
    Color(0xff8bd448),
    Color(0xff2aa8f2)
)

@Preview(showBackground = true)
@Composable
fun KtalkSampleTheme() {
    KtalkSampleTheme {
        ExampleTextAnnotatedString()
    }
}