package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    suspend fun getPosts() = getPostUseCase.invoke()
}