package org.wit.m.ui.schoolList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SchoollistViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the list of all schools Fragment"
    }
    val text: LiveData<String> = _text

}