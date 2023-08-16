package com.mybasecode.noteapp.data.repositories.localrepositories

import com.mybasecode.noteapp.data.entities.Note

interface NoteRepository {
    suspend fun getNotes(): List<Note>
    suspend fun storeNote(note: Note)
    suspend fun updateNote(id: Long, title: String, content: String, hex: String)
    suspend fun deleteNote(noteId: Long)
}