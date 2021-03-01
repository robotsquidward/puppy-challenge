package com.example.androiddevchallenge.model

import com.google.gson.annotations.SerializedName

data class Pup (
    val id: Int,
    val name: String? = null,
    val description: String? = null,
    val species: String? = null,
    val breeds: Breed? = null,
    val colors: Color? = null,
    val age: String? = null,
    val gender: String? = null,
    val size: String? = null,
    val coat: String? = null,
    val photos: HashMap<String, String>? = null,
    val status: String? = null,
    @SerializedName("published_at")
    val publishedAt: String? = null,
    val contact: Contact? = null,
)

data class Breed (
    val primary: String? = null,
    val secondary: String? = null,
    val mixed: Boolean = false,
    val unknown: Boolean = false,
)

data class Color (
    val primary: String? = null,
    val secondary: String? = null,
    val tertiary: String? = null,
)

data class Contact (
    val email: String? = null,
    val phone: String? = null,
    val address: Address? = null,
)

data class Address (
    val address1: String? = null,
    val address2: String? = null,
    val city: String? = null,
    val state: String? = null,
    val postcode: String? = null,
    val country: String? = null,
)