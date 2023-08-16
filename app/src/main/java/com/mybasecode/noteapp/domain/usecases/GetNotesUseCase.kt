package com.mybasecode.noteapp.domain.usecases

import com.mybasecode.noteapp.data.entities.Note
import com.mybasecode.noteapp.data.repositories.localrepositories.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(): List<Note> {
        return noteRepository.getNotes()
    }
}