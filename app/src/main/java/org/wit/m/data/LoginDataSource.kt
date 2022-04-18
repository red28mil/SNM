package org.wit.m.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.wit.m.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */

private lateinit var auth: FirebaseAuth;


class LoginDataSource {



    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
           auth = Firebase.auth
            val currentUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "string")
            return Result.Success(currentUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        Firebase.auth.signOut()

    }
}