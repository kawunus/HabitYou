package com.kawunus.habitu.diary.data.dto

data class NoteDto(
    val id: Int? = 0,
    val content: String,
    val date: Long,
    val title: String
)
