package com.dicoding.berpesanapp.ui.screen.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.berpesanapp.data.model.Post
import com.dicoding.berpesanapp.data.repository.FirestoreRepository
import com.dicoding.berpesanapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PostViewModel (val repository: FirestoreRepository) : ViewModel() {

    private val _state : MutableStateFlow<UiState<List<Post>>> = MutableStateFlow(UiState.Loading)
    val state : StateFlow<UiState<List<Post>>> get() = _state

    fun addPost(post: Post) {
        repository.addPost(post)
    }

    fun getAllPosts() {
        viewModelScope.launch {
            repository.getAllPosts()
                .catch { e ->
                    _state.value = UiState.Error(e.message.toString())
                }
                .collect { data ->
                    _state.value = UiState.Success(data)
                }
        }
    }

}