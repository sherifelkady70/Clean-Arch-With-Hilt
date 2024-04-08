package com.route.cleanarch_with_hilt.di

import com.route.cleanarch_with_hilt.data.api.Api
import com.route.cleanarch_with_hilt.data.reposiroty.RepositoryImpl
import com.route.cleanarch_with_hilt.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    @Singleton
    @Provides
    fun provideApiInstance() : Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideApiRepository(api:Api) : Repository{
        return RepositoryImpl(api)
    }
}