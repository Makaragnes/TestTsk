package com.example.testtsk.store

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.testtsk.model.JokeModel

object MainStore {

    val listOfJokes = mutableStateListOf<String>()
    lateinit var joke: String
    val jokeS = mutableStateOf(
        JokeModel(
            null,
            "",
            "",
            "",
            "",
            "",
            ""
        )
    )
    //val list = listOf<String>()
    //val listOfJokes = mutableStateOf(List<String>)
}