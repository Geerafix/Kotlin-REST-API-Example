package com.nonogramnest.model.achievement

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nonogramnest.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AchievementRepository {
    private val api = RetrofitClient.getClient()
    private val achievementInterface = api.create(AchievementInterface::class.java)

    private val ERROR_TAG = "ERROR";

    fun getAllAchievements(): LiveData<List<Achievement>> {
        val data = MutableLiveData<List<Achievement>>()

        achievementInterface.fetchAchievements().enqueue(object: Callback<ArrayList<Achievement>> {
            override fun onFailure(call: Call<ArrayList<Achievement>>, t: Throwable) {
                Log.d(ERROR_TAG, t.toString())
            }

            override fun onResponse(call: Call<ArrayList<Achievement>>, response: Response<ArrayList<Achievement>>) {
                data.value = response.body()
            }
        })

        return data
    }
}