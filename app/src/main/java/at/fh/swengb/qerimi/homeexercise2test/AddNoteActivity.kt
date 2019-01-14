package at.fh.swengb.qerimi.homeexercise2test

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_addnote.*

class AddNoteActivity : AppCompatActivity() {

    private val listOfNotes = mutableListOf<Notes>()

    private var noteAdapter = Adapter()

    private lateinit var dataBase : RoomDatabaseNotez

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)
        dataBase = RoomDatabaseNotez.getDatabase(applicationContext)
        title = "Note App"


    }

    fun saveNote(v: View) {


        val title = title_name.text.toString()
        val content = content_name.text.toString()

        listOfNotes.add(Notes(title, content))

        val item = listOfNotes.firstOrNull() ?: return
        dataBase.noteDao.insert(item)
        val itemz = dataBase.noteDao.showAllNotes()
        noteAdapter.updateDataBase(itemz)



        finish()



    }
}
