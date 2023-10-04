package com.notetakingapp.notemanagement.controller;


import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.mapper.UpdateNoteMapper;
import com.notetakingapp.notemanagement.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UpdateNoteMapper updateNoteMapper;

    // fetch all the notes over here...

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // fetch a particular note over here...
    @GetMapping("/{noteId}")
    public Note getNote(@PathVariable("noteId") String id){
        Note note_value = noteService.getNote(id);
        return note_value;
    }

    // update the note over here ...
    @PutMapping
    public String UpdateNote(@RequestBody updateNoteDto dto){
        String note_id = noteService.updateNote(dto);
        if(note_id.equals(dto.getId()))
        {
            return note_id;
        }
        return "null";
    }

    // delete the note record...
    @PostMapping("/{noteId}")
    public String DeleteNote(@PathVariable("noteId") String id)
    {
        return noteService.deleteNote(id);
    }

    // create the note ...
    @PostMapping
    public String CreateNote(@RequestBody createNoteDto dto)
    {
        String id =  noteService.createNote(dto);
        if(id.equals(dto.getId()))
        {
            return id;
        }
        return null;
    }



}
