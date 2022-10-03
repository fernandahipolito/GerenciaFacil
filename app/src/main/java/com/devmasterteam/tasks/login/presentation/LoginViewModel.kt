package com.devmasterteam.tasks.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.login.domain.PersonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LoginViewModel(private val personRepository: PersonRepository) : ViewModel() {

    val email: String = ""
    val password: String = ""
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    init {
        viewModelScope.launch {
            personRepository.login(email = email, password = password)
                .flowOn(dispatcher)
                .collect()
        }
    }

    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }

}

private fun <T> Flow<T>.collect() {
    TODO("Not yet implemented")
}
