package ru.hmhub.agentsAndroid.domain.repository

import ru.hmhub.agentsAndroid.data.local_db.models.Sample
import kotlinx.coroutines.flow.Flow

interface SampleRepository{
    interface Remote {
        suspend fun doNetworkCall()
    }
    interface Local{
        fun getAll() : Flow<List<Sample>>
    }
}
