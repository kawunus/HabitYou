package com.kawunus.habityou.notes.data.impl

import com.kawunus.habityou.core.database.dao.NoteDao
import com.kawunus.habityou.notes.data.dto.NoteDto
import com.kawunus.habityou.notes.domain.api.NoteRepository
import com.kawunus.habityou.utils.mappers.toNoteDto
import com.kawunus.habityou.utils.mappers.toNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNote(note: NoteDto) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: NoteDto) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: NoteDto) {
        noteDao.updateNote(note.toNoteEntity())
    }

    override suspend fun getAllNotes(): Flow<List<NoteDto>> = flow {
        val noteList = noteDao.getAllNotes().map { it.toNoteDto() }
        emit(noteList)
    }
}