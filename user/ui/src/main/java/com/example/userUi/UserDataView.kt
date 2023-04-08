package com.example.userUi

import com.example.userDomain.UserData


data class UserDataView(
    val color: String,
    val id: Int,
    val name: String,
    val pantone_value: String,
    val year: Int,
)

fun UserData.toUserDataView() = UserDataView(
    color = color,
    id = id,
    name = name,
    pantone_value = pantone_value,
    year = year,
)
