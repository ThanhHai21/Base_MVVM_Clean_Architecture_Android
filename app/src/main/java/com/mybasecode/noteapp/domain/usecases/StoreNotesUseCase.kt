package com.mybasecode.noteapp.domain.usecases

import com.mybasecode.noteapp.data.entities.Note
import com.mybasecode.noteapp.data.repositories.localrepositories.NoteRepository
import javax.inject.Inject

class StoreNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(title: String, content: String, colorHex: String) {
        return noteRepository.storeNote(
            Note(
                time = System.currentTimeMillis(),
                title = title,
                content = content,
                colorHex = colorHex
            )
        )
    }
}