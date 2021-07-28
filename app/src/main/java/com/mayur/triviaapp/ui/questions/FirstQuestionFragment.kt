package com.mayur.triviaapp.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mayur.triviaapp.R
import com.mayur.triviaapp.data.cache.UserData
import com.mayur.triviaapp.databinding.FragmentFirstBinding
import org.json.JSONObject

class FirstQuestionFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private val args: FirstQuestionFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)


        binding?.btnNext?.setOnClickListener {

            val checkedId = binding?.radioGroup?.checkedRadioButtonId ?: -1

            if (checkedId > 0) {
                val selectedButton = binding?.root?.findViewById<RadioButton>(checkedId)

                val ans = selectedButton?.text.toString()

                val json = JSONObject()
                json.put("que", binding?.textQuestion?.text.toString())
                json.put("ans", ans)

                // fetch UserData as safeArgs
                val userData = args.userDataEntity

                userData.first_qa = json.toString()
                val action = FirstQuestionFragmentDirections.firstToSecond(userData)
                findNavController().navigate(action)


            } else {
                Toast.makeText(context, getString(R.string.cricketer_valid_msg), Toast.LENGTH_LONG)
                    .show()
            }

        }

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}