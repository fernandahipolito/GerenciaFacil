package com.devmasterteam.tasks.di

import com.devmasterteam.tasks.login.domain.PersonRepository

import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import com.devmasterteam.tasks.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val loginModule = module {

    viewModel { LoginViewModel(get()) }
    //factory { get<OkHttpClient.Builder()>(PersonRepository::class.java) }
    factory { RetrofitClient.getService(PersonRepository::class.java) }

    ///factory
    //factory { get<OkHttpClient>().apply { PersonService::class.java }}

   // factory<PersonRepository> {
    //    PersonRepositoryImpl(personService = get())
   // }

}





