package com.mayur.triviaapp.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mayur.triviaapp.R
import com.mayur.triviaapp.data.cache.UserData
import com.mayur.triviaapp.databinding.FragmentFirstBinding
import com.mayur.triviaapp.databinding.FragmentNameBinding

class NameQuestionFragment : Fragment() {

    private var binding: FragmentNameBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding?.btnNext?.setOnClickListener {

            val name = binding?.editName?.text.toString()

            if (name.isBlank()) {
                Toast.makeText(context, getString(R.string.name_valid_msg), Toast.LENGTH_LONG)
                    .show()
            } else {

                val userData = UserData(timestamp = System.currentTimeMillis(), name = name)
                // pase UserData as argument from this fragment to First Fragment
                val action = NameQuestionFragmentDirections.nameToFirst(userData)
                findNavController().navigate(action)
            }
        }

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}