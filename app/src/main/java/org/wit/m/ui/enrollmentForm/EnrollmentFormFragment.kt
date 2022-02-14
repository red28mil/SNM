package org.wit.m.ui.enrollmentForm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.wit.m.databinding.FragmentEnrollmentBinding


class EnrollmentFormFragment : Fragment() {

    private lateinit var enrollmentFormViewModel: EnrollmentFormViewModel
    private var _binding: FragmentEnrollmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enrollmentFormViewModel =
            ViewModelProvider(this).get(EnrollmentFormViewModel::class.java)

        _binding = FragmentEnrollmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textEnrollmentForm
        enrollmentFormViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}