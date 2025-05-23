package com.kawunus.habitu.diary.domain.model

import java.util.Date

data class Note(
    val id: Int? = 0,
    val content: String,
    val date: Long
)