package com.mayur.triviaapp.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUserData(userData: UserData)

    @Query("SELECT * FROM userData")
    fun getAllUserData(): List<UserData>
}