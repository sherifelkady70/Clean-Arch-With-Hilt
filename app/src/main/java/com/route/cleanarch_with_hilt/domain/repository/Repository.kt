package com.route.cleanarch_with_hilt.domain.repository

import com.route.cleanarch_with_hilt.domain.entity.MyModelItem
import retrofit2.Call

interface Repository {
    suspend fun getUsers() : Call<List<MyModelItem>>
}