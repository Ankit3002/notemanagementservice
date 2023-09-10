package com.notetakingapp.notemanagement.service;

import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;

import java.util.List;

public interface NoteService {

    // method to fetch all notes from the database...

    List<Note> getAllNotes();

    // method to update a note into the database...
    String updateNote(updateNoteDto dto);

    // method to fetch a particular note from the database...
    Note getNote(String id);

    // method to delete a particular note from the database...
    String deleteNote(String id);

    String createNote(createNoteDto dto);

}
