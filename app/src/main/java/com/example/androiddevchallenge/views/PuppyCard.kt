package com.example.androiddevchallenge.views

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyCard(
    pup: Pup,
    onClick: (Pup) -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onClick(pup) },
            elevation = 4.dp,
            shape = RoundedCornerShape(
                CornerSize(16.dp),
                CornerSize(16.dp),
                CornerSize(16.dp),
                CornerSize(16.dp)
            )
        ) {
            Column {
                Row(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        bitmap = BitmapFactory.decodeStream(LocalContext.current.assets.open("puppy.png"))
                            .asImageBitmap(),
                        contentDescription = "Puppy Image",
                        contentScale = ContentScale.FillBounds,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .padding(8.dp)
                            .clip(
                                RoundedCornerShape(
                                    CornerSize(16.dp),
                                    CornerSize(16.dp),
                                    CornerSize(16.dp),
                                    CornerSize(16.dp)
                                )
                            ),
                    )
                    Text(
                        text = pup.name ?: "",
                        style = typography.h3,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Column(
                    modifier = Modifier.padding(
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
                ) {
                    SimpleFlowRow(
                        verticalGap = 4.dp,
                        horizontalGap = 2.dp,
                        alignment = Alignment.Start,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        if (!pup.species.isNullOrBlank()) {
                            PuppyChip(
                                text = pup.species,
                            )
                        }
                        if (!pup.gender.isNullOrBlank()) {
                            PuppyChip(
                                text = pup.gender,
                            )
                        }
                        if (!pup.age.isNullOrBlank()) {
                            PuppyChip(
                                text = pup.age,
                            )
                        }
                        if (!pup.size.isNullOrBlank()) {
                            PuppyChip(
                                text = pup.size,
                            )
                        }
                        pup.breeds?.also { breed ->
                            if (breed.unknown) {
                                PuppyChip("UNKNOWN")
                            } else {
                                if (!breed.primary.isNullOrBlank()) {
                                    PuppyChip(
                                        text = breed.primary,
                                    )
                                }
                                if (!breed.secondary.isNullOrBlank()) {
                                    PuppyChip(text = breed.secondary,
                                    )
                                }
                                if (!breed.mixed) {
                                    PuppyChip(
                                        text = "Mix",
                                    )
                                }
                            }
                        }
                    }
                    Text(
                        text = pup.description ?: "",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    MyTheme(darkTheme = true) {
        PuppyCard(
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
            ),
            onClick = {}
        )
    }
}