package org.wit.m

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class NoteActivity : AppCompatActivity() {

    private lateinit var recycler_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_preview)
        init()
    }
        private fun init() {
            val layoutManager = LinearLayoutManager(this)

            recycler_view.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
            recycler_view.layoutManager = layoutManager
            recycler_view.adapter = MyAdapter(this, generateList())
        }

        private fun generateList(): List<String> {
            return listOf(
                "https://www.wexfordcbs.ie/wp-content/school-policies/",
                "https://www.stpeterscollege.net",
                "https://www.marvel.com",
                "https://www.marvel.com"
            )
        }



}







