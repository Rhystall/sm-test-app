package com.rhystalgie.smtestapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rhystalgie.smtestapp.R
import com.rhystalgie.smtestapp.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    // Ambil args dari SafeArgs
    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvYourName.text = args.userName

        binding.btnChooseUser.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            findNavController().navigate(action)
        }


        // Setup toolbar back navigation
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        // Terima result dari ThirdFragment
        parentFragmentManager.setFragmentResultListener("selectedUserKey", viewLifecycleOwner) { _, bundle ->
            val selectedUserName = bundle.getString("selectedUserName")
            binding.tvSelectedUser.text = selectedUserName ?: "Selected User Name"
        }

        // Tombol Choose User navigasi ke ThirdFragment
        binding.btnChooseUser.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
