package com.devmasterteam.tasks.login.data.model

import com.google.gson.annotations.SerializedName

class PersonModel {//retorno de create e de login é o mesmo, esse aqui

    @SerializedName("token")
    lateinit var token: String

    @SerializedName("personKey")
    lateinit var personKey: String

    @SerializedName("name")
    lateinit var name: String

}