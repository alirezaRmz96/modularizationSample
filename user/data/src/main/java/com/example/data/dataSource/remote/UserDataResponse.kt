package com.example.data.dataSource.remote

import com.example.data.dataSource.local.UserDataEntity

data class UserDataResponse(
    val color: String,
    val id: Int,
    val name: String,
    val pantone_value: String,
    val year: Int,
) {
    fun toUserDataEntity() = UserDataEntity(
        color = color,
        id = id,
        name = name,
        pantone_value = pantone_value,
        year = year,
    )
}