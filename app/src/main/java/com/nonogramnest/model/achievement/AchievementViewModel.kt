package com.nonogramnest.model.achievement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AchievementViewModel {
    private var achievementRepository: AchievementRepository?= null
    var achievementListLiveData: LiveData<List<Achievement>>?= null

    init {
        achievementRepository = AchievementRepository()
        achievementListLiveData = MutableLiveData()
    }

    fun getAllAchievements() {
        achievementListLiveData = achievementRepository?.getAllAchievements()
    }
}