package com.devmasterteam.tasks.login.data.service

import com.devmasterteam.tasks.service.model.PersonModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PersonService {

    //http://devmasterteam.com/CursoAndroidAPI/Authentication/Login
    //http://devmasterteam.com/CursoAndroidAPI/Authentication/Create

    @POST("Authentication/Login")
    @FormUrlEncoded //é a maneira que são enviadas as informações(body)
    suspend fun login(
       @Field("email") email: String,
       @Field("password") password: String
   ): PersonModel


    @POST("Authentication/Create")
    @FormUrlEncoded
    fun create(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        //@Field("receivenews") receivenews: Boolean -> Já vem false por padrão, então não coloca
    ): PersonModel
}