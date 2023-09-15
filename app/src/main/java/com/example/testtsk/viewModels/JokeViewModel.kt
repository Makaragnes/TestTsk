package com.example.testtsk.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtsk.network.TestTaskService
import com.example.testtsk.screens.MainScreen
import com.example.testtsk.store.MainStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    val testTaskService: TestTaskService
): ViewModel() {

    var isLoadingJoke = mutableStateOf(false)

    fun getJoke(){
        Log.d("SOME", "start")
        viewModelScope.launch {
            try {
                val resp = testTaskService.getJoke(MainStore.joke)

                if (resp.isSuccessful) {
                    MainStore.jokeS.value = resp.body()!!
                    isLoadingJoke.value = true
                } else {
                    resp.raw()
                }
                throw RuntimeException("RuntimeException in coroutine")
            } catch (exception: Exception) {
                println("Handle $exception")
            }
        }
    }
}