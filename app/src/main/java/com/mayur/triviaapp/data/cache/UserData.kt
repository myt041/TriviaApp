package com.mayur.triviaapp.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "userData")
data class UserData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val timestamp: Long = 0,
    val name: String = "",
    var first_qa: String ="",
    var second_qa: String =""

) : Serializable
