package org.wit.m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.wit.m.FormData
import org.wit.m.R
import kotlin.coroutines.EmptyCoroutineContext.get



class FormActivity : AppCompatActivity() {

    private val formDataCollectionRef = Firebase.firestore.collection("FormData")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        val btnUploadData = findViewById<Button>(R.id.btnUploadData)
        btnUploadData.setOnClickListener {

            val name = findViewById<EditText>(R.id.etName)
            val sex = findViewById<EditText>(R.id.etSex)
            val age = findViewById<EditText>(R.id.etAge)
            val address = findViewById<EditText>(R.id.etAddress)
            val childName = findViewById<EditText>(R.id.etChildName)
            val FormData = FormData("name", "age", "sex", "address", "child name")
            saveFormData(FormData)
        }

        val btnRetrieveData = findViewById<Button>(R.id.btnUploadData)
        btnRetrieveData.setOnClickListener {
            retrieveFormData()

        }
    }
    private fun retrieveFormData() = CoroutineScope(Dispatchers.IO).launch {
    try {
        val querySnapshot = formDataCollectionRef.get()

        val sb = StringBuilder()
         for (document in querySnapshot.result) {
            val FormData = document.toObject<FormData>()
            sb.append("$FormData\n")
        }
            withContext(Dispatchers.Main) {
           // = sb.toString()
        }
            } catch (e: Exception) {
            withContext(Dispatchers.Main) {
            Toast.makeText(this@FormActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
        private fun saveFormData(formData: FormData) = CoroutineScope(Dispatchers.IO).launch {
            try {
                formDataCollectionRef.add(formData)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@FormActivity, "Successfully saved data.", Toast.LENGTH_LONG)
                        .show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@FormActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }


}


// Write a message to the database
      //  var database = Firebase.database
      //  val myRef = database.getReference("message")


