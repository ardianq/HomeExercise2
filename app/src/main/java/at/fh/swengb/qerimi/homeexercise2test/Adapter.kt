package at.fh.swengb.qerimi.homeexercise2test

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.fh.swengb.qerimi.homeexercise2test.R.id.parent
import kotlinx.android.synthetic.main.activity_addnote.view.*
import kotlinx.android.synthetic.main.note_item.view.*

class Adapter : RecyclerView.Adapter<NoteListViewHolder>() {

    var listOfNotes = mutableListOf<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): NoteListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.note_item, parent, false)
        return NoteListViewHolder(noteItemView)

    }

    fun updateDataBase(updatedList: List<Notes>) {

        listOfNotes = updatedList.toMutableList()
        notifyDataSetChanged()

    }


    override fun getItemCount(): Int {
        return listOfNotes.count()
    }

    override fun onBindViewHolder(vHolder: NoteListViewHolder, position: Int) {
        val note = listOfNotes[position]
        vHolder.bindItem(note)

    }
}

    class NoteListViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {

        fun bindItem(note: Notes) {
            itemView.title_text.text = note.Title
            itemView.content_text.text = note.Content


        }

    }

