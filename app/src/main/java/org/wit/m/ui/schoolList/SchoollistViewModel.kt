package org.wit.m.ui.schoolList

import android.content.Intent
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.wit.m.ListActivity
import org.wit.m.R

class SchoollistViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the list of all schools Fragment"
    }
    val text: LiveData<String> = _text


}