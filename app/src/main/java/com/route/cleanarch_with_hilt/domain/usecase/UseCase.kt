package com.route.cleanarch_with_hilt.domain.usecase

import com.route.cleanarch_with_hilt.domain.entity.MyModelItem
import com.route.cleanarch_with_hilt.domain.repository.Repository
import retrofit2.Call
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repo : Repository
) {

    suspend operator fun invoke() : Call<List<MyModelItem>> {
        return repo.getUsers()
    }
}