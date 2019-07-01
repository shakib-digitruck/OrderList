package com.example.orderlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel(){

    var pos : Int = 0

    fun setValue(num : Int){
        pos = num
    }

    fun getValue() : Int {
        return pos
    }

}
