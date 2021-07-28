package com.mayur.triviaapp.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mayur.triviaapp.R
import com.mayur.triviaapp.databinding.FragmentSecondBinding
import org.json.JSONObject

class SecondQuestionFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null
    private val args: SecondQuestionFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        binding?.btnNext?.setOnClickListener {
            var ans = ""

            if (binding?.checkA?.isChecked == true) {
                ans = binding?.checkA?.text.toString()
            }
            if (binding?.checkB?.isChecked == true) {
                if (ans.isBlank()) {
                    ans = binding?.checkB?.text.toString()
                } else {
                    ans = "$ans, ${binding?.checkB?.text.toString()}"
                }
            }
            if (binding?.checkC?.isChecked == true) {
                if (ans.isBlank()) {
                    ans = binding?.checkC?.text.toString()
                } else {
                    ans = "$ans, ${binding?.checkC?.text.toString()}"
                }
            }
            if (binding?.checkD?.isChecked == true) {
                if (ans.isBlank()) {
                    ans = binding?.checkD?.text.toString()
                } else {
                    ans = "$ans, ${binding?.checkD?.text.toString()}"
                }
            }

            if (ans.isBlank()) {
                Toast.makeText(context, getString(R.string.color_valid_msg), Toast.LENGTH_LONG)
                    .show()
            } else {

                val json = JSONObject()
                json.put("que", binding?.textQuestion?.text.toString().substringBefore("\n"))
                json.put("ans", ans)

                val userData = args.userDataEntity
                userData.second_qa = json.toString()
                val action = SecondQuestionFragmentDirections.secondToSummary(userData)
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