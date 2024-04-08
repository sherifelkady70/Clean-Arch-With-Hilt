package com.route.cleanarch_with_hilt.data.api

import com.route.cleanarch_with_hilt.domain.entity.MyModelItem
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("users")
    fun getUsers() : Call<List<MyModelItem>>
}