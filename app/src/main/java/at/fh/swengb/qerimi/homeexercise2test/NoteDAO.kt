package at.fh.swengb.qerimi.homeexercise2test

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NotesDAO {

    @Insert
    fun insert(note: Notes)

    @Query ("SELECT * from Notizen")
    fun showAllNotes(): List<Notes>


}