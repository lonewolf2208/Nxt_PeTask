package com.example.nxtpetask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nxtpetask.model.PageDetails
import com.example.nxtpetask.network.RetrofitClient
import com.example.nxtpetask.repo.MandatoryRepo
import com.example.nxtpetask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: MandatoryRepo) : ViewModel() {
    fun getData(): StateFlow<Resource<PageDetails>> =
        repo.getData().stateIn(
            scope = viewModelScope,
            initialValue =Resource.Loading(),
            started = SharingStarted.WhileSubscribed(5000)
        )


}