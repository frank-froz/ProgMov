package com.huaytalla.franklin.laboratoriocalificado03

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val teacherList = MutableLiveData<List<Teacher>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorApi = MutableLiveData<String>()

    init {
        getAllTeachers()
    }

    private fun getAllTeachers() {
        isLoading.postValue(true)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getTeachers()
                if (response.isSuccessful) {
                    response.body()?.let {
                        teacherList.postValue(it.teachers)
                    }
                } else {
                    errorApi.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                errorApi.postValue("Excepción: ${e.message}")
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}