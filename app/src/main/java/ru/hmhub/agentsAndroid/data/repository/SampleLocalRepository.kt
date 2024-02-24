package ru.hmhub.agentsAndroid.data.repository

import ru.hmhub.agentsAndroid.data.local_db.dao.SampleDao
import ru.hmhub.agentsAndroid.data.local_db.models.Sample
import ru.hmhub.agentsAndroid.domain.repository.SampleRepository
import kotlinx.coroutines.flow.Flow

class SampleLocalRepository(
    private val dao: SampleDao
) : SampleRepository.Local {
    override fun getAll() : Flow<List<Sample>> {
        return dao.getAll()
    }

}