package com.relaxingsoft.applicationcontentprovider

import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.relaxingsoft.applicationcontentprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES
import com.relaxingsoft.applicationcontentprovider.database.NotesProvider.Companion.URI_NOTES

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks< Cursor > {

    lateinit var noteRecyclerView: RecyclerView
    lateinit var noteAdd: FloatingActionButton

    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById( R.id.note_add )
        noteAdd.setOnClickListener{  }

        adapter = NotesAdapter()
        adapter.setHasStableIds( true )

        noteRecyclerView = findViewById( R.id.notes_recycler )
        noteRecyclerView.layoutManager = LinearLayoutManager( this )
        noteRecyclerView.adapter = adapter
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> = CursorLoader( this, URI_NOTES, null, null, null, TITLE_NOTES )

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if ( data != null ) {

        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }
}