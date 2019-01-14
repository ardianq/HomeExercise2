package at.fh.swengb.qerimi.homeexercise2test

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Notes::class], version = 4)
abstract class RoomDatabaseNotez : RoomDatabase() {

    abstract val noteDao: NotesDAO

    companion object {
        fun getDatabase(context: Context): RoomDatabaseNotez {
            return Room.databaseBuilder(context, RoomDatabaseNotez::class.java, "note-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
