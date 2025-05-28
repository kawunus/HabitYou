package com.kawunus.habityou.domain.model

import androidx.annotation.StringRes
import com.kawunus.habityou.R

enum class NoteType(@StringRes val userReadableStringRes: Int) {
    USEFUL_HABIT(R.string.note_type_useful_habit), BAD_HABIT(R.string.note_type_bad_habit), NONE(R.string.note_type_none)
}