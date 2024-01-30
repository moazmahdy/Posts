package com.example.data.di

import com.example.data.remote.PostApi
import com.example.data.repoimpl.GetPostRepoImpl
import com.example.domain.repo.GetPostRepo
import com.example.domain.usecase.GetPostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideGetPostRepo(api: PostApi): GetPostRepo {
        return GetPostRepoImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetPostUseCase(repo: GetPostRepo): GetPostUseCase {
        return GetPostUseCase(repo)
    }
}