package com.devmasterteam.tasks.login.presentation

import com.devmasterteam.tasks.login.data.model.PersonModel


sealed class ResultState {
    data class Success (val data: PersonModel) : ResultState()
    object Error : ResultState()
}

