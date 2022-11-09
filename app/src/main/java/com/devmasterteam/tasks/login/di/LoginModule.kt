package com.devmasterteam.tasks.login.di

import com.devmasterteam.tasks.LoginNavigation
import com.devmasterteam.tasks.LoginNavigationImpl
import com.devmasterteam.tasks.login.data.repository.PersonRepositoryImpl
import com.devmasterteam.tasks.login.data.service.PersonService
import com.devmasterteam.tasks.login.domain.PersonRepository
import com.devmasterteam.tasks.login.presentation.LoginViewModel
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

internal const val URL = "http://devmasterteam.com/CursoAndroidAPI/"

val loginModule = module {

    factory {
        OkHttpClient.Builder()
            //.cache(get())
            .build()
    }

    factory {
        GsonBuilder().create()
    }

    factory {
        val contentType = MediaType.get("application/json")
        Retrofit.Builder()
            .baseUrl(URL)
            .client(get())
            .addConverterFactory(Json.asConverterFactory(contentType))
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

val navigationModule = module {
    factory<LoginNavigation> { LoginNavigationImpl() }
}

