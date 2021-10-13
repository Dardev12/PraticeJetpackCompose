package com.dardev.notecomposeapp.di

import android.app.Application
import androidx.room.Room
import com.dardev.notecomposeapp.feature.note.data.data_source.YanoteDatabase
import com.dardev.notecomposeapp.feature.note.data.repository.YanoteRepositoryImpl
import com.dardev.notecomposeapp.feature.note.domain.repository.YanoteRepository
import com.dardev.notecomposeapp.feature.note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideYanoteDatabase(app:Application): YanoteDatabase{
        return Room.databaseBuilder(
            app,
            YanoteDatabase::class.java,
            YanoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideYanoteRepository(db:YanoteDatabase):YanoteRepository{
        return YanoteRepositoryImpl(db.yanoteDAO)
    }

    @Provides
    @Singleton
    fun provideYanoteUseCases(repository: YanoteRepository):YanoteUseCases{
        return YanoteUseCases(
            avoirYanotes = AvoirYanotes(repository),
            supprimerYanote = SupprimerYanote(repository),
            ajouterYanote = AjouterYanote(repository),
            avoirUnYanote = AvoirUneYanote(repository)
        )
    }
}