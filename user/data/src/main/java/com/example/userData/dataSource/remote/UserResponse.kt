package com.example.userData.dataSource.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @field:Json(name = "data") val userData: List<UserDataResponse>?,
    @field:Json(name = "total") val total: Int?,
    @field:Json(name = "total_pages") val totalPages: Int?,
)