package com.miu.walmartstore

import java.io.Serializable

//Implementation of Task2
class User(
    var firstName: String,
    var lastName: String,
    var userName: String,
    var password: String
) : Serializable{

    override fun toString():String{
        return "User (firstName=$firstName, lastName=$lastName, username=$userName, password=$password)"
    }
}