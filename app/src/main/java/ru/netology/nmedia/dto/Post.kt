package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val like: Int,
    val likedByMe: Boolean = false,
   // val likeCount: Int,
    val repost: Int,
    val view: Int,
    //var shareCount: Int
)