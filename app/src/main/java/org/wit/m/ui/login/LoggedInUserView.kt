package org.wit.m.ui.login


import com.google.firebase.auth.FirebaseUser


/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(

    val displayName: String,
    //var user: FirebaseUser


//... other data fields that may be accessible to the UI
)