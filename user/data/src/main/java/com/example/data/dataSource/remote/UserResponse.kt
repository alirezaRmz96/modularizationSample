package com.example.data.dataSource.remote

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val userData: List<UserDataResponse>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)