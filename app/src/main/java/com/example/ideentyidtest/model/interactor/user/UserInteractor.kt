package com.example.ideentyidtest.model.interactor.user

import com.example.ideentyidtest.entity.core.signup.User
import com.example.ideentyidtest.model.repository.user.UserRepository

/**
 * Business logic and mappers for auth
 *
 */
class UserInteractor(private val userRepository: UserRepository) {

    /**
     * Get user from @[UserRepository]
     *
     * @param login = user login
     */
    suspend fun getUser(login: String) = userRepository.getUser(login)

    /**
     * Save user to @[UserRepository]
     *
     * @param user = current user
     */
    suspend fun saveUser(user: User) = userRepository.saveUser(user)
}