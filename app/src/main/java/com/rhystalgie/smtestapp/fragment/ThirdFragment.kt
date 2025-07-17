package com.rhystalgie.smtestapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.rhystalgie.smtestapp.R
import com.rhystalgie.smtestapp.UserAdapter
import com.rhystalgie.smtestapp.UserViewModel
import com.rhystalgie.smtestapp.databinding.FragmentThirdBinding
import kotlinx.coroutines.flow.collectLatest


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<UserViewModel>()

    private lateinit var adapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserAdapter { user ->
            // handle user click, bisa pakai navController popBackStack dengan result
        }

        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.userPager.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            adapter.refresh()
        }

        adapter.addLoadStateListener { loadState ->
            binding.swipeRefresh.isRefreshing = loadState.source.refresh is LoadState.Loading
            binding.tvEmptyState.visibility =
                if (adapter.itemCount < 1 && loadState.source.refresh is LoadState.NotLoading) View.VISIBLE
                else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
