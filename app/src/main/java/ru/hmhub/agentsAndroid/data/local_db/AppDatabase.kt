package ru.hmhub.agentsAndroid.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.hmhub.agentsAndroid.data.local_db.dao.SampleDao
import ru.hmhub.agentsAndroid.data.local_db.models.Sample

@Database(
    entities = [Sample::class],
    version = 1,
    exportSchema = false,
//    autoMigrations = [
//        AutoMigration(from = 1, to = 2)//, spec = AppDatabase.AutoMigrationFrom2To3::class)
//    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract val sampleDao: SampleDao

//    @RenameTable(fromTableName = "samples", toTableName = "projectModel")
//    class AutoMigrationFrom2To3: AutoMigrationSpec
}