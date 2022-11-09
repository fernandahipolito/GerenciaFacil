package com.devmasterteam.tasks.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmasterteam.tasks.login.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LoginViewModel(private val personRepository: PersonRepository

) : ViewModel() {


    private val _initLogin = MutableLiveData<ResultState>()
    val initLogin: LiveData<ResultState> get() = _initLogin

    fun doLogin(email: String,password:String) {
        viewModelScope.launch {
            personRepository.login(email, password)
                .flowOn(Dispatchers.IO)
                .catch {
                    _initLogin.value = ResultState.Error
                }
                .collect { result ->
                    _initLogin.value = ResultState.Success(data = result)
                }
        }
    }
}