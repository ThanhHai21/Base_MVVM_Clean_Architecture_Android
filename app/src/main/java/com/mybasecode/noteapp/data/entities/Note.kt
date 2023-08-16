package com.mybasecode.noteapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val time: Long,
    val title: String,
    val content: String,
    val colorHex: String
)