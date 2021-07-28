package com.mayur.triviaapp.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayur.triviaapp.data.cache.UserData
import com.mayur.triviaapp.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val allUsersData = MutableLiveData<List<UserData>>()

    fun insertUserData(userData: UserData) {
        viewModelScope.launch {
            repository.insertUserData(userData)
        }
    }


    fun fetchUsersData() {
        viewModelScope.launch {
            val data = repository.getAllUserData()
            allUsersData.postValue(data)
        }
    }


}