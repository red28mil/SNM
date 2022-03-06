package org.wit.m.ui.schoolList

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.wit.m.ListActivity
import org.wit.m.MapsActivity
import org.wit.m.R
import org.wit.m.databinding.FragmentSchoollistBinding


class SchoollistFragment : Fragment() {

    private lateinit var schoollistViewModel: SchoollistViewModel
    private var _binding: FragmentSchoollistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        schoollistViewModel =
            ViewModelProvider(this).get(SchoollistViewModel::class.java)

        _binding = FragmentSchoollistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSchoolList
        schoollistViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root


       
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}