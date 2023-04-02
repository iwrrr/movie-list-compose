package com.hwaryun.movielist.presentation.movie_list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(
    percentage: Float,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    radius: Dp = 30.dp,
    color: Color = Color(0xFF21D07A),
    strokeWidth: Dp = 2.dp,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier.size(radius)
        ) {
            drawCircle(
                color = Color(0xFF081B21),
                radius = 50f
            )
            drawCircle(
                color = Color(0xFF204529),
                style = Stroke(width = strokeWidth.toPx())
            )
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * percentage,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round),
            )
        }
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontSize = fontSize,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append((percentage * 100).toInt().toString())
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 6.sp,
                        color = Color.White,
                        baselineShift = BaselineShift.Superscript,
                    )
                ) {
                    append("%")
                }
            }
        )
    }
}