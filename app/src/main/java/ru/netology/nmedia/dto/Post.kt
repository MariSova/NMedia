package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    //val like: Int,
    var likedByMe: Boolean = false,
    val likeCount: Int,
    var shareCount: Int
)