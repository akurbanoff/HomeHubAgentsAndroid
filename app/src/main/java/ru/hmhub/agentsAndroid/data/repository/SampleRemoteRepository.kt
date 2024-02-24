package ru.hmhub.agentsAndroid.data.repository

import ru.hmhub.agentsAndroid.data.remote.SampleApi
import ru.hmhub.agentsAndroid.domain.repository.SampleRepository

class SampleRemoteRepository(
    private val api: SampleApi
) : SampleRepository.Remote {
    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }
}