package com.rhystalgie.smtestapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.rhystalgie.smtestapp.R
import com.rhystalgie.smtestapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheck.setOnClickListener {
            val text = binding.etPalindrome.text.toString()
            val message = if (isPalindrome(text)) "isPalindrome" else "not palindrome"
            AlertDialog.Builder(requireContext())
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        }

        binding.btnNext.setOnClickListener {
            val name = binding.etName.text.toString()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name)
            findNavController().navigate(action)
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val clean = text.replace("\\s".toRegex(), "").lowercase()
        return clean == clean.reversed()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
