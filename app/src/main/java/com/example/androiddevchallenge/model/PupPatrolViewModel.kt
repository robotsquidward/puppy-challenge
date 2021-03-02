package com.example.androiddevchallenge.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PupPatrolViewModel : ViewModel() {
    private val _selectedPup: MutableLiveData<Pup?> = MutableLiveData(null)
    val selectedPup: LiveData<Pup?> = _selectedPup

    val pups = listOf(
        Pup(
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
        Pup(
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
        Pup(
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
    )

    fun pupSelected(pup: Pup) {
        _selectedPup.postValue(pup)
    }
}