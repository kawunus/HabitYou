package com.kawunus.habityou.notes.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: Int = 0,
    val content: String,
    val date: Long,
    val title: String
) : Parcelable