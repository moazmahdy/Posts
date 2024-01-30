package com.example.domain.usecase

import com.example.domain.repo.GetPostRepo

class GetPostUseCase (
    private val repo: GetPostRepo
) {

    suspend operator fun invoke() = repo.getAllPosts()
}