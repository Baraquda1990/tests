package com.example.a24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel:ViewModel() {
    val message_to_activity:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message_to_fragment1:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message_to_fragment2:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}