package com.example.routemate.repository

import com.example.routemate.signUp.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class AuthRepository(

     private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
     private val firestore: FirebaseFirestore =
         FirebaseFirestore.getInstance()

) {

    suspend fun  login(
        email: String,
        password: String
    ) {

        auth.signInWithEmailAndPassword(
            email,
            password
        ).await()
    }

    /*********************************** signup ************************************/
    suspend fun signUp(
        name: String,
        email: String,
        phone: String,
        company: String,
        home: String,
        office: String,
        password: String
    ){
        /****************** create user Firebase Authentication Account ********/
        val result = auth.createUserWithEmailAndPassword(
            email,
            password
        ).await()

        // Get UID
        val uid = result.user?.uid?: throw Exception("User not found")

        // create user object
        val user = User(
            uid = uid,
            name = name,
            email = email,
            phone = phone,
            company = company,
            home = home,
            office = office
        )
        // save user in Firestore
        firestore.
                collection("users")
            .document(uid)
            .set(user)
            .await()
    }




}