package com.mybasecode.noteapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel(
    val id: Long,
    val time: Long,
    val title: String,
    val content: String,
    val colorHex: String
) : Parcelable