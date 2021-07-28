package com.mayur.triviaapp.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mayur.triviaapp.R
import com.mayur.triviaapp.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private val viewModel by viewModels<QuestionViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)

        viewModel.allUsersData.observe(viewLifecycleOwner,{

            if(it.isNotEmpty()){

                binding?.recyclerHistory?.apply {
                    adapter = HistoryAdapter(it)
                }
            }

        })

        viewModel.fetchUsersData()


        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}