package com.dicoding.berpesanapp.data.repository

import android.util.Log
import com.dicoding.berpesanapp.data.model.Post
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class FirestoreRepository {
    private val db = FirebaseFirestore.getInstance()

    fun addPost(post: Post) {
        db.collection("posts")
            .add(post)
            .addOnSuccessListener {
                Log.d("FirestoreSucc", "Success")
            }
            .addOnFailureListener { e ->
                Log.d("FirestoreFail", "${e.message}")
            }
    }

    fun getAllPosts(): Flow<List<Post>> = callbackFlow {
        val listener = db.collection("posts")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                val posts = snapshot?.documents?.mapNotNull { doc ->
                    doc.toObject(Post::class.java)?.copy(id = doc.id)
                } ?: emptyList()

                trySend(posts)
            }
        awaitClose {
            listener.remove()
        }
    }

    fun getPostById(id: String) : Flow<Post> = callbackFlow {
        val listener = db.collection("posts").document(id)
            .addSnapshotListener()
    }
}