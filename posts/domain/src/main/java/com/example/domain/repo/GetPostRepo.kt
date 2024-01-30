package com.example.domain.repo

import com.example.domain.models.PostResponseItem
import com.example.domain.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface GetPostRepo {

    suspend fun getAllPosts(): Flow<ResponseState<List<PostResponseItem>>>
}