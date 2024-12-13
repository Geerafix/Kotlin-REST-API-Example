package com.nonogramnest.model.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nonogramnest.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val api = RetrofitClient.getClient()
    private val userInterface = api.create(UserInterface::class.java)

    private val ERROR_TAG = "ERROR";

    fun getAllUsers(): LiveData<List<User>> {
        val data = MutableLiveData<List<User>>()

        userInterface.fetchUsers().enqueue(object: Callback<ArrayList<User>> {
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Log.d(ERROR_TAG, t.toString())
            }

            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                data.value = response.body()
            }
        })

        return data
    }
}