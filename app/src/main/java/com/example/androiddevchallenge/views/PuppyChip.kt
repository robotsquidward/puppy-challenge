package com.example.androiddevchallenge.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun PuppyChip(
    text: String,
    backgroundColor: Color = colors.secondary,
    textColor: Color = colors.onSecondary,
) {
    Surface(
        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, end = 8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small,
        color = backgroundColor
    ) {
        Row {
            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                fontFamily = FontFamily.Monospace,
                color = textColor,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
