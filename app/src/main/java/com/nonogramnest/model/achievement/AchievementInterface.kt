package com.nonogramnest.model.achievement

import retrofit2.Call
import retrofit2.http.GET

interface AchievementInterface {
    @GET("admin/achievements")
    fun fetchAchievements(): Call<ArrayList<Achievement>>
}