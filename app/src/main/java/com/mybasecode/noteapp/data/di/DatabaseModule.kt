package com.mybasecode.noteapp.data.di

import android.content.Context
import androidx.room.Room
import com.mybasecode.noteapp.data.database.NoteDatabase
import com.mybasecode.noteapp.data.database.daos.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providerDb(@ApplicationContext context: Context): NoteDatabase {
        return Room
            .databaseBuilder(context, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun providesNotificationDao(appDatabase: NoteDatabase): NoteDao {
        return appDatabase.appDao()
    }
}