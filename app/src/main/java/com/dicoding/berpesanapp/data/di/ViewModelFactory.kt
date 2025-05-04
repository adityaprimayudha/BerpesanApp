package com.dicoding.berpesanapp.data.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.berpesanapp.data.repository.FirestoreRepository
import com.dicoding.berpesanapp.ui.screen.post.PostViewModel

class ViewModelFactory(private val repository: FirestoreRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class :"+modelClass.name)
    }
}