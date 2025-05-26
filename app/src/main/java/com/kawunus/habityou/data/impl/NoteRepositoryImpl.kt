package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.NoteDao
import com.kawunus.habityou.data.dto.NoteDto
import com.kawunus.habityou.domain.api.repository.NoteRepository
import com.kawunus.habityou.utils.mappers.toNoteDto
import com.kawunus.habityou.utils.mappers.toNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

    override fun getAllNotes(): Flow<List<NoteDto>> {
        return noteDao.getAllNotes().map { list ->
            list.map {
                it.toNoteDto()
            }
        }
    }
}