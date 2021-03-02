/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.PupPatrolViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.views.PuppyCard

class MainActivity : AppCompatActivity() {

    private val viewModel: PupPatrolViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(pupPatrolViewModel: PupPatrolViewModel) {
    val selectedPup: Pup? by pupPatrolViewModel.selectedPup.observeAsState()

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "\uD83D\uDC15 PUP PATROL \uD83D\uDC29",
                            fontFamily = FontFamily.Monospace,
                        )
                    },
                    elevation = 8.dp
                )
            }
        ) {
            selectedPup?.let {
                Text("Whatever")
            } ?: PupList(
                pups = pupPatrolViewModel.pups,
                onClick = { pupSelected ->
                    pupPatrolViewModel.pupSelected(pupSelected)
                }
            )
        }
    }
}

@Composable
fun PupList(
    pups: List<Pup>,
    onClick: (Pup) -> Unit
) {
    LazyColumn {
        items(pups) { pup ->
            PuppyCard(
                pup = pup,
                onClick = onClick
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(PupPatrolViewModel())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(PupPatrolViewModel())
    }
}
