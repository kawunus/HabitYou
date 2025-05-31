package com.kawunus.habityou.data.dto

import com.kawunus.habityou.domain.model.NoteType

data class NoteDto(
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String,
    val type: NoteType,
)