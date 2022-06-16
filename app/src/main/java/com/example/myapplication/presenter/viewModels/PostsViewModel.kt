package com.example.myapplication.presenter.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Post.api.Posts
import com.example.myapplication.domain.useCase.GetPostsByUserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsByUserIdUseCase: GetPostsByUserIdUseCase
) : ViewModel() {
    //    val dataFromDB = MutableLiveData<Flow<List<UsersEntity>>>()
    val data = MutableLiveData<List<Posts>>()

    fun onCreate(id: Int) {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                val result: List<Posts> = getPostsByUserIdUseCase(id)
//                data.postValue(result)
//            }
//        }
    }
}