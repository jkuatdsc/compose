package com.moose.pets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class MainViewmodel: ViewModel() {

    private val _email: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String> = _email
    fun changeEmail(value: String) = value.also { _email.value = it }

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading
    fun changeLoading(value: Boolean) = value.also { _loading.value = it }

    val numbers = flowOf(1, 2, 3, 5, 6, 7, 8, 9, 0).onEach { delay(1000) }
}