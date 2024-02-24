package ru.hmhub.agentsAndroid.data.local_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.hmhub.agentsAndroid.data.local_db.models.Sample
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {

    @Query("SELECT * FROM samples")
    fun getAll(): Flow<List<Sample>>

    @Insert
    fun insert(sample: Sample)

}