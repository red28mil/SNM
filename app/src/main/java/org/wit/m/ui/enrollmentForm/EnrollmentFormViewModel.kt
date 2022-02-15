package org.wit.m.ui.enrollmentForm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnrollmentFormViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Please fill out the form to enroll you Son/Daughter in First year"
    }
    val text: LiveData<String> = _text
}