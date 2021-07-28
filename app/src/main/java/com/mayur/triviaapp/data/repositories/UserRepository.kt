package com.mayur.triviaapp.data.repositories

import com.mayur.triviaapp.data.cache.AppDatabase
import com.mayur.triviaapp.data.cache.UserData

class UserRepository(
    private val appDatabase: AppDatabase
) {


    // insert data to room
    suspend fun insertUserData(userData: UserData) {
        appDatabase.userDao().insertUserData(userData)
    }

    // fetch data from room

    suspend fun getAllUserData() : List<UserData>{
       return appDatabase.userDao().getAllUserData()
    }
}