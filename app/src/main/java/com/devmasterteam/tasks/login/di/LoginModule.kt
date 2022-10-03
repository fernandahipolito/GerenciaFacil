package com.devmasterteam.tasks.di

import com.devmasterteam.tasks.login.data.repository.PersonRepositoryImpl
import com.devmasterteam.tasks.login.data.service.PersonService
import com.devmasterteam.tasks.login.domain.PersonRepository
import com.devmasterteam.tasks.login.presentation.LoginViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal const val URL = "http://devmasterteam.com/CursoAndroidAPI/"

val loginModule = module {

    factory {
        OkHttpClient.Builder()
            .cache(get())
            .build()
    }

    factory {
        GsonBuilder().create()
    }

    factory {
        Retrofit.Builder()
            .baseUrl(URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    factory {
        get<Retrofit>().create(PersonService::class.java)
    }

    factory<PersonRepository> {
        PersonRepositoryImpl(personService = get())
    }

    viewModel { LoginViewModel(get()) }

}





