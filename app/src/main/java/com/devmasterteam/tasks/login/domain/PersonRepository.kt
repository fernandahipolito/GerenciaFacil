package com.devmasterteam.tasks.login.domain

import com.devmasterteam.tasks.login.data.model.PersonModel
import kotlinx.coroutines.flow.Flow


interface PersonRepository {
    suspend fun login(email: String, password: String): Flow<PersonModel>
}