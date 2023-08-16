package com.mybasecode.noteapp.domain.usecases

import com.mybasecode.noteapp.data.repositories.localrepositories.NoteRepository
import javax.inject.Inject

class DeleteNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(noteId: Long) {
        return noteRepository.deleteNote(noteId)
    }
}