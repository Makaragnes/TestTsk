package com.example.testtsk.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtsk.network.TestTaskService
import com.example.testtsk.store.MainStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val testTaskService: TestTaskService
): ViewModel() {

    var isLoadingList = mutableStateOf(false)

    fun getList(){
        Log.d("SOME", "value")
        viewModelScope.launch {
            try {
                val resp = testTaskService.getJokeList()

                if (resp.isSuccessful) {
                    Log.d("SOME", resp.body().toString())
                    for (value in resp.body()!!.iterator()){
                        Log.d("SOME", value)
                        MainStore.listOfJokes.add(value)
                    }
                    isLoadingList.value = true
                    Log.d("SOME", isLoadingList.value.toString())
                } else {
                    resp.message()
                }
                throw RuntimeException("RuntimeException in coroutine")
            } catch (exception: Exception) {
                println("Handle $exception")
            }
        }
    }
}