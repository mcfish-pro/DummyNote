package com.example.dummynote;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {
    EditText etTitle, etNote;
    private DB db;
    private long noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        etTitle = findViewById(R.id.etTitle);
        etNote = findViewById(R.id.etNote);
        db = new DB(this);
        noteId = getIntent().getLongExtra("noteId", 0);
        Cursor c = db.queryById(noteId);
        c.moveToFirst();
        int index = c.getColumnIndex("title");
        String title = c.getString(index);
        index = c.getColumnIndex("note");
        String note = c.getString(index);
        etTitle.setText(title);
        etNote.setText(note);
    }
}