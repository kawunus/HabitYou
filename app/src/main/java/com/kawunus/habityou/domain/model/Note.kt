package com.kawunus.habityou.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String,
    val type: NoteType,
    val habitId: Int? = null
) : Parcelable