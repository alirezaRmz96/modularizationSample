package com.example.userData.dataSource.remote

import com.example.userData.dataSource.local.UserDataEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * This annotation lets Moshi know it can create an object of this type from JSON data
 * Moshi create adapter for it if u don't use it and don't create the adapter for
 * yourself , you'll get a runtime error from Moshi.
 */
@JsonClass(generateAdapter = true)
data class UserDataResponse(
    @field:Json(name = "color") val color: String?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "pantone_value") val pantone_value: String?,
    @field:Json(name = "year") val year: Int?,
) {
    fun toUserDataEntity() = UserDataEntity(
        color = color.orEmpty(),
        id = id ?: throw Exception("id is null here"),
        name = name.orEmpty(),
        pantone_value = pantone_value.orEmpty(),
        year = year ?: throw Exception("Year is null here"),
    )
}