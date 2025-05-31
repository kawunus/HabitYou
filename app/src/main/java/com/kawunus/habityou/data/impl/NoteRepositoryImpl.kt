package com.kawunus.habityou.data.impl

import com.kawunus.habityou.data.database.dao.BadHabitNoteDao
import com.kawunus.habityou.data.database.dao.NoteDao
import com.kawunus.habityou.data.database.dao.UsefulHabitNoteDao
import com.kawunus.habityou.data.dto.NoteDto
import com.kawunus.habityou.domain.api.repository.NoteRepository
import com.kawunus.habityou.domain.model.NoteType
import com.kawunus.habityou.utils.mappers.toBadHabitNoteEntity
import com.kawunus.habityou.utils.mappers.toNoteDto
import com.kawunus.habityou.utils.mappers.toNoteEntity
import com.kawunus.habityou.utils.mappers.toUsefulHabitNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val noteDao: NoteDao,
    private val usefulHabitNoteDao: UsefulHabitNoteDao,
    private val badHabitNoteDao: BadHabitNoteDao
) : NoteRepository {
    override suspend fun insertNote(note: NoteDto) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: NoteDto) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override suspend fun updateNote(oldNote: NoteDto, newNote: NoteDto, habitId: Int?) {
        when (oldNote.type) {
            NoteType.USEFUL_HABIT -> {
                usefulHabitNoteDao.delete(newNote.toUsefulHabitNoteEntity(habitId ?: return))
            }

            NoteType.BAD_HABIT -> {
                badHabitNoteDao.delete(oldNote.toBadHabitNoteEntity(habitId ?: return))
            }

            NoteType.NONE -> {
                noteDao.deleteNote(oldNote.toNoteEntity())
            }
        }

        when (newNote.type) {
            NoteType.USEFUL_HABIT -> {
                usefulHabitNoteDao.insert(newNote.toUsefulHabitNoteEntity(habitId ?: return))
            }

            NoteType.BAD_HABIT -> {
                badHabitNoteDao.insert(newNote.toBadHabitNoteEntity(habitId ?: return))
            }

            NoteType.NONE -> {
                noteDao.insertNote(newNote.toNoteEntity())
            }
        }
    }

    override fun getAllNotes(): Flow<List<NoteDto>> {
        val notes = noteDao.getAllNotes().map {
            it.map { entity -> entity.toNoteDto() }
        }
        val usefulHabitNotes = usefulHabitNoteDao.getAllNotes().map {
            it.map { entity -> entity.toNoteDto() }
        }
        val badHabitNotes = badHabitNoteDao.getAllNotes().map {
            it.map { entity -> entity.toNoteDto() }
        }
        return combine(
            notes,
            usefulHabitNotes,
            badHabitNotes
        ) { notesList, usefulHabitNotesList, badHabitNotesList ->

            val combinedNotes = mutableListOf<NoteDto>()

            combinedNotes.addAll(notesList)
            combinedNotes.addAll(usefulHabitNotesList)
            combinedNotes.addAll(badHabitNotesList)

            combinedNotes.sortedByDescending { it.date }
        }
    }
}