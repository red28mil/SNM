package org.wit.m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.m.databinding.ActivityLogoutBinding

import android.content.Intent
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


private lateinit var binding: ActivityLogoutBinding;
private lateinit var googleSignInClient: GoogleSignInClient
private lateinit var user: FirebaseAuth



class LogoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        user = FirebaseAuth.getInstance()
        if(user.currentUser != null){
            user.currentUser?.let { binding.logout.text = it.email
            }


        }

        binding.logout.setOnClickListener{
            user.signOut()
          //  GoogleSignInClient.signOut()
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            Toast.makeText(
                applicationContext,
                "Goodbye",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
        Firebase.auth.signOut()
    }

}
