package com.kawunus.habitu.diary.domain.model

data class Note(
    val id: Int? = 0,
    val content: String,
    val date: Long,
    val title: String
)