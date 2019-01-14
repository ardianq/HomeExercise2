package at.fh.swengb.qerimi.homeexercise2test

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Notizen")
class Notes (val Title: String,
             val Content: String) {
    @PrimaryKey(autoGenerate = true)
    var note_id:Int = 0

}
