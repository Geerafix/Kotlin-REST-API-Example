package com.nonogramnest.model.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private var userRepository: UserRepository?= null
    var userListLiveData: LiveData<List<User>>?= null

    init {
        userRepository = UserRepository()
        userListLiveData = MutableLiveData()
    }

    fun getAllUsers() {
        userListLiveData = userRepository?.getAllUsers()
    }
}