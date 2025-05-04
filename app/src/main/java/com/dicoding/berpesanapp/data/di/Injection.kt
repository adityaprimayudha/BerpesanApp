package com.dicoding.berpesanapp.data.di

import com.dicoding.berpesanapp.data.repository.FirestoreRepository

object Injection {
    fun provideRepository() : FirestoreRepository {
        return FirestoreRepository()
    }
}