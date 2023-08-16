package com.mybasecode.noteapp.data.di

import com.mybasecode.noteapp.data.repositories.localrepositories.NoteRepository
import com.mybasecode.noteapp.data.repositories.localrepositories.NoteRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNoteRepository(
        noteRepositoryImp: NoteRepositoryImp
    ): NoteRepository
}
