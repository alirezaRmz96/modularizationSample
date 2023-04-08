package com.example.data.dataSource.local

import androidx.room.Entity
import com.example.domain.UserData

@Entity(tableName = "Users")
data class UserDataEntity(
    val color: String,
    val id: Int,
    val name: String,
    val pantone_value: String,
    val year: Int,
){
    fun toUserData() = UserData(
        color = color,
        id = id,
        name = name,
        pantone_value = pantone_value,
        year = year,
    )
}
