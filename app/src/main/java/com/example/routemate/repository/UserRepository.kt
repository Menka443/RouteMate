package com.example.routemate.repository

import com.example.routemate.signUp.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository(

    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

) {

    // Current logged-in user UID
    private val currentUid = auth.currentUser?.uid

    /**
     * Get current logged-in user's profile
     */
    suspend fun getCurrentUser(): User? {

        val snapshot = firestore
            .collection("users")
            .document(currentUid!!)
            .get()
            .await()

        return snapshot.toObject(User::class.java)
    }

    /**
     * Get all users
     */
    suspend fun getAllUsers(): List<User> {

        val snapshot = firestore
            .collection("users")
            .get()
            .await()

        return snapshot.toObjects(User::class.java)
    }

}