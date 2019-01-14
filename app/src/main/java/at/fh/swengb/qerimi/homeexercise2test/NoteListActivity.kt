package at.fh.swengb.qerimi.homeexercise2test

import android.app.Application
import android.content.Intent
import android.graphics.LinearGradient
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_notelistactivity.*

class NoteListActivity : AppCompatActivity() {

    private val listNotes = mutableListOf<Notes>()

    private var noteAdapter = Adapter()

    private lateinit var dataBase : RoomDatabaseNotez


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notelistactivity)
        title = "Note App"

        val name = intent.getStringExtra("sharedPrefsName")
        val age = intent.getIntExtra("sharedPrefsAge",0).toString()

        user_info.text = "Show notes for $name, $age"

        dataBase = RoomDatabaseNotez.getDatabase(applicationContext)
        recycler.layoutManager = LinearLayoutManager(this)
        noteAdapter = Adapter()
        recycler.adapter = noteAdapter

        val itemz = dataBase.noteDao.showAllNotes()
        noteAdapter.updateDataBase(itemz)

        insertNoteDataBase()
    }

    override fun onResume() {
        super.onResume()

        val itemz = dataBase.noteDao.showAllNotes()
        noteAdapter.updateDataBase(itemz)

        insertNoteDataBase()



    }

    fun  addNote(v: View) {

        val intent = Intent(this, AddNoteActivity::class.java)

        startActivity(intent)




    }

    fun insertNoteDataBase() {
        val item = listNotes.firstOrNull() ?: return
        dataBase.noteDao.insert(item)
        val itemz = dataBase.noteDao.showAllNotes()
        noteAdapter.updateDataBase(itemz)


    }
}
