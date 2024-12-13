package com.nonogramnest.model.user

import retrofit2.Call
import retrofit2.http.GET

interface UserInterface {
    @GET("admin/users")
    fun fetchUsers(): Call<ArrayList<User>>
}