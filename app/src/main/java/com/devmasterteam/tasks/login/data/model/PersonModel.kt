package com.devmasterteam.tasks.login.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonModel(

    @SerialName("token")
    val token: String?,

    @SerialName("personKey")
    val personKey: String,

    @SerialName("name")
    val name: String

)//retorno de create e de login é o mesmo, esse aqui

