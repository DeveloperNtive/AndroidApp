package com.example.myapplication.presenter.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Post.api.Posts
import com.example.myapplication.domain.model.user.api.User
import com.example.myapplication.domain.useCase.GetPostsByUserIdUseCase
import com.example.myapplication.domain.useCase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getPostsByUserIdUseCase: GetPostsByUserIdUseCase
) : ViewModel() {
    //    val dataFromDB = MutableLiveData<Flow<List<UsersEntity>>>()
    val dataListUsers = MutableLiveData<List<User>>()
    val dataListPosts = MutableLiveData<List<Posts>>()

    fun onCreate() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val userUseCase: List<User> = getUsersUseCase()
                val postUseCase: List<Posts> = getPostsByUserIdUseCase()
                dataListPosts.postValue(postUseCase)
                dataListUsers.postValue(userUseCase)
            }
        }
    }
}