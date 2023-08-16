package com.mybasecode.noteapp.presentation.mappers

import com.mybasecode.noteapp.data.entities.Note
import com.mybasecode.noteapp.presentation.base.BaseMapper
import com.mybasecode.noteapp.presentation.model.NoteModel

class NoteMapper : BaseMapper<Note, NoteModel>() {
    override fun transform(entity: Note): NoteModel {
        return NoteModel(
            id = entity.id,
            time = entity.time,
            title = entity.title,
            content = entity.content,
            colorHex = entity.colorHex
        )
    }
}