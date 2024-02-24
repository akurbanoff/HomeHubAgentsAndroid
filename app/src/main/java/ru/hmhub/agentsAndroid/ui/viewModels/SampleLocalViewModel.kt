package ru.hmhub.agentsAndroid.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.hmhub.agentsAndroid.domain.repository.SampleRepository
import ru.hmhub.agentsAndroid.ui.states.SampleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SampleLocalViewModel @Inject constructor(
    private val localRepository: SampleRepository.Local,
    private val remoteRepository: SampleRepository.Remote
): ViewModel() {

    private val _state = MutableStateFlow(SampleState())
    @OptIn(ExperimentalCoroutinesApi::class)
    private val _samples = MutableStateFlow(localRepository.getAll()).flatMapLatest { localRepository.getAll() }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val state = combine(_state, _samples){state, samples ->
        state.copy(
            samples = samples
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), SampleState())
}