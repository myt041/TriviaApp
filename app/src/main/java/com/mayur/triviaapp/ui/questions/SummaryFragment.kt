package com.mayur.triviaapp.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mayur.triviaapp.R
import com.mayur.triviaapp.databinding.FragmentSummaryBinding
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class SummaryFragment : Fragment() {

    private var binding: FragmentSummaryBinding? = null
    private val args: SummaryFragmentArgs by navArgs()
    private val viewModel by viewModels<QuestionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_summary, container, false)

        val userData = args.userDataEntity

        binding?.textName?.setText("Hello ${userData.name},")

        val json1 = JSONObject(userData.first_qa)
        binding?.qa1?.setText("${json1.getString("que")} \n\n ${json1.getString("ans")}")


        val json2 = JSONObject(userData.second_qa)
        binding?.qa2?.setText("${json2.getString("que")} \n\n ${json2.getString("ans")}")

        // room database entry
        viewModel.insertUserData(userData)

        binding?.btnFinish?.setOnClickListener {
            findNavController().navigate(R.id.summary_to_name)
        }


        binding?.btnHistory?.setOnClickListener {
            findNavController().navigate(R.id.summary_to_history)
        }

        return binding?.root

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}