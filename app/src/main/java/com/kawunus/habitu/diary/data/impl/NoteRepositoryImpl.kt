package com.kawunus.habitu.diary.data.impl

import android.util.Log
import com.kawunus.habitu.core.database.dao.NoteDao
import com.kawunus.habitu.diary.data.dto.NoteDto
import com.kawunus.habitu.diary.domain.api.NoteRepository
import com.kawunus.habitu.utils.toNoteDto
import com.kawunus.habitu.utils.toNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNote(note: NoteDto) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: NoteDto) {
        noteDao.deleteNote(note.toNoteEntity())
        Log.d("DiaryViewModel", "1 Удаляем заметку: ${note}")
    }

    override suspend fun updateNote(note: NoteDto) {
        noteDao.updateNote(note.toNoteEntity())
    }

    override suspend fun getAllNotes(): Flow<List<NoteDto>> = flow {
        val noteList = noteDao.getAllNotes().map { it.toNoteDto() }
        emit(noteList)
    }
}