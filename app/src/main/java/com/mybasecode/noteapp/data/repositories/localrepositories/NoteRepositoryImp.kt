package com.mybasecode.noteapp.data.repositories.localrepositories

import com.mybasecode.noteapp.data.database.daos.NoteDao
import com.mybasecode.noteapp.data.entities.Note
import javax.inject.Inject

class NoteRepositoryImp @Inject constructor(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun getNotes(): List<Note> {
        return noteDao.getNotes()
    }

    override suspend fun storeNote(note: Note) {
        noteDao.storeNote(note)
    }

    override suspend fun updateNote(id: Long, title: String, content: String, hex: String) {
        noteDao.updateNote(id, title, content, hex)
    }

    override suspend fun deleteNote(noteId: Long) {
        noteDao.deleteNote(noteId)
    }
}