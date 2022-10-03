package com.devmasterteam.tasks.login.data.repository

import com.devmasterteam.tasks.login.data.model.PersonModel
import com.devmasterteam.tasks.login.domain.PersonRepository
import com.devmasterteam.tasks.login.data.service.PersonService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class PersonRepositoryImpl(
    private val personService: PersonService
    ) : PersonRepository {
    override suspend fun login(email: String, password: String): Flow<PersonModel> {
       return flowOf(personService.login(email = email, password = password))
    }
}