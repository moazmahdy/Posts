package com.example.data.remote

import com.example.domain.models.PostResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getAllPosts(): Response<List<PostResponseItem>>
}