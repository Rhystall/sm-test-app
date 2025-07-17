package com.rhystalgie.smtestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.rhystalgie.smtestapp.api.ApiConfig

class UserViewModel : ViewModel() {
    val userPager = Pager(PagingConfig(pageSize = 10)) {
        UserPagingSource(ApiConfig.getApiService())
    }.flow.cachedIn(viewModelScope)
}
