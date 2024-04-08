package com.route.cleanarch_with_hilt.data.reposiroty

import com.route.cleanarch_with_hilt.data.api.Api
import com.route.cleanarch_with_hilt.domain.entity.MyModelItem
import com.route.cleanarch_with_hilt.domain.repository.Repository
import retrofit2.Call
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(
    private val api : Api
) : Repository {
    override suspend fun getUsers(): Call<List<MyModelItem>> {
        return api.getUsers()
    }
}