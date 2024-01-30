package com.example.data.repoimpl

import com.example.data.remote.PostApi
import com.example.domain.models.PostResponseItem
import com.example.domain.repo.GetPostRepo
import com.example.domain.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Exception

@Singleton
class GetPostRepoImpl @Inject constructor(
    private val api: PostApi
) : GetPostRepo {
    override suspend fun getAllPosts(): Flow<ResponseState<List<PostResponseItem>>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val response = api.getAllPosts()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ResponseState.Success(it))
                    }
                } else {
                    emit(ResponseState.Failed(Exception(response.message())))
                }
            } catch (e: Exception) {
                emit(ResponseState.Failed(e))
            }
        }
    }
}