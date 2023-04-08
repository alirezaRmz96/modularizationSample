package com.example.userData.dataSource.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.userDomain.UserData

@Entity(tableName = "Users")
data class UserDataEntity(
    val color: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val pantone_value: String,
    val year: Int,
) {
    fun toUserData() = UserData(
        color = color,
        id = id,
        name = name,
        pantone_value = pantone_value,
        year = year,
    )
}
