package com.devmasterteam.tasks.login.domain

import com.devmasterteam.tasks.service.model.PersonModel
import kotlinx.coroutines.flow.Flow


interface PersonRepository {
    suspend fun login(email: String, password: String): Flow<PersonModel>
}