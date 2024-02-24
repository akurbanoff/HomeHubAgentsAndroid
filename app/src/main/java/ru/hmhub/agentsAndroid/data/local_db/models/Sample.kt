package ru.hmhub.agentsAndroid.data.local_db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "samples")
data class Sample (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String
)