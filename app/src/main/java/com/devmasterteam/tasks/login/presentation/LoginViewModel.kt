package com.devmasterteam.tasks.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.login.domain.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LoginViewModel(private val personRepository: PersonRepository) : ViewModel() {

    val email: String = ""
    val password: String = ""

    // val loginChange = MutableLiveData<PersonModel>()
//
   // fun loginSeiLa() {
   //     personRepository.login()
   //         .collect()
   // }
    init {
        viewModelScope.launch {
            personRepository.login(email = email, password = password)
                .collect()

        }
    }
    //private val personRepository = PersonRepository()
    /**
     * Faz login usando API
     */
  //  fun doLogin(email: String, password: String) {
      //  personRepository.login(email,password)
    //}


    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }

}

private fun <T> Flow<T>.collect() {
    TODO("Not yet implemented")
}
