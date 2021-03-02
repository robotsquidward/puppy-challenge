package com.example.androiddevchallenge.views

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyDetails(
    pup: Pup
) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Image(
                bitmap = BitmapFactory.decodeStream(LocalContext.current.assets.open("puppy.png"))
                    .asImageBitmap(),
                contentDescription = "Puppy Image",
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )
            Text(
                text = pup.name ?: "",
                style = typography.h3,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PuppyDetailsPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetails(
            pup = Pup(
                id = 1,
                name = "Bud",
                description = "Let me tell you all about this great doggo.",
                age = "Young",
                gender = "Male",
                size = "Small",
                breeds = Breed(
                    primary = "Pug",
                    secondary = null,
                    mixed = false,
                    unknown = false
                ),
                photos = HashMap<String, String>().apply {
                    put(
                        "small",
                        "https://picsum.photos/300/300"
                    )
                }
            )
        )
    }
}