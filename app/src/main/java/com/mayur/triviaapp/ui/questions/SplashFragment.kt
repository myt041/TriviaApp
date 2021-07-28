package com.mayur.triviaapp.ui.questions

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mayur.triviaapp.R
import com.mayur.triviaapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var binding: FragmentSplashBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)


        // spalsh screen for 3 secound
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.splash_to_name)
        }, 3000)

        return binding?.root
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}