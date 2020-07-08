package com.example.ideentyidtest.model.interactor.user

import com.example.ideentyidtest.entity.core.signup.User
import com.example.ideentyidtest.model.repository.user.UserRepository

class UserInteractor(private val userRepository: UserRepository) {

    suspend fun getUser(login: String) = userRepository.getUser(login)

    suspend fun saveUser(user: User) = userRepository.saveUser(user)
}