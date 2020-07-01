package com.example.bottomnavigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.bottomnavigationexample.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        //when button is clicked get textfieldvalue
        binding.myButton.setOnClickListener {
            var textToShow = "Field cannot be empty."   //default text to show in toast
            val userInputText = getText()               //get userinput
            val duration = Toast.LENGTH_SHORT           //duration to show toast

            if(userInputText.isNotEmpty()){
                textToShow = "Your input was $userInputText"
            }

            val toast = Toast.makeText(requireContext(), textToShow, duration)
            toast.show()
        }

        return binding.root
    }

    fun getText(): String{
        return binding.myTextField.text.toString()
    }
}