package at.fh.swengb.qerimi.homeexercise2test

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Note App"


    }


    fun addUser(view:View) {

        val name = user_name.text.toString()
        val age = user_age.text.toString().toIntOrNull() ?: 0


        val intent = Intent(this, NoteListActivity::class.java)

        intent.putExtra("sharedPrefsName", name)
        intent.putExtra("sharedPrefsAge", age)

            startActivity(intent)

        }





    }


