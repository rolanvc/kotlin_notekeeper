package com.example.notekeeper2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity

class NotesListActivity : AppCompatActivity() {
    var listNotes: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)
        setSupportActionBar(findViewById(R.id.toolbar))
        this.listNotes = findViewById(R.id.listNotes)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)

        }
        listNotes?.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, DataManager.notes)

        listNotes?.setOnItemClickListener{_,_,position,_ ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activityIntent)
        }
    }
    override fun onResume() {
        super.onResume()
        (listNotes?.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}