package com.mybasecode.noteapp.domain.usecases

import com.mybasecode.noteapp.data.repositories.localrepositories.NoteRepository
import javax.inject.Inject

class UpdateNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(noteId: Long, title: String, content: String, colorHex: String) {
        return noteRepository.updateNote(
            id = noteId,
            title = title,
            content = content,
            hex = colorHex
        )
    }
}