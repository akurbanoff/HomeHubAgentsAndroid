package ru.hmhub.agentsAndroid.ui.states

import ru.hmhub.agentsAndroid.data.local_db.models.Sample

data class SampleState(
    val samples: List<Sample> = emptyList(),
    val title: String = ""
)