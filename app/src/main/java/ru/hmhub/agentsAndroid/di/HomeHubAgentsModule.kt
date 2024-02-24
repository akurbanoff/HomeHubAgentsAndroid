package ru.hmhub.agentsAndroid.di

import android.app.Application
import androidx.room.Room
import ru.hmhub.agentsAndroid.data.local_db.AppDatabase
import ru.hmhub.agentsAndroid.data.remote.SampleApi
import ru.hmhub.agentsAndroid.data.repository.SampleLocalRepository
import ru.hmhub.agentsAndroid.data.repository.SampleRemoteRepository
import ru.hmhub.agentsAndroid.domain.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeHubAgentsModule {

    @Provides
    @Singleton
    fun createDb(applicationContext: Application) : AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "homehub_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSampleApi(): SampleApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(SampleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSampleRemoteRepository(api: SampleApi) : SampleRepository.Remote {
        return SampleRemoteRepository(api)
    }

    @Provides
    @Singleton
    fun provideSampleLocalRepository(db: AppDatabase): SampleRepository.Local{
        return SampleLocalRepository(db.sampleDao)
    }
}