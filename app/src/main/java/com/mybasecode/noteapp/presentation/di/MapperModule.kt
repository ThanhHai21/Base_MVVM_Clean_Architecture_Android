package com.mybasecode.noteapp.presentation.di

import com.mybasecode.noteapp.presentation.mappers.NoteMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Provides
    @Singleton
    fun provideNoteMapper(): NoteMapper {
        return NoteMapper()
    }
}
