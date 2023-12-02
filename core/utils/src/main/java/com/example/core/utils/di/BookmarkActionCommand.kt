package com.example.core.utils.di


data class BookmarkActionCommand(val action: ActionEntity) : Command


data class ActionEntity(
    val id: String,
    val categoryId: String,
    val likeOrDisLike: Boolean
)