package com.notetakingapp.notemanagement.controller;


import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.entity.User;
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

    // fetch all the notes over here...

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/user")
    public List<Note> getAllNotesUser(@RequestBody User user)
    {
        return noteService.getAllNoteUser(user);
    }

    // fetch a particular note over here...
    @GetMapping("/{noteId}")
    public Note getNote(@PathVariable("noteId") String id){
        return noteService.getNote(id);
    }

    // update the note over here ...
    @PutMapping
    public String UpdateNote(@RequestBody updateNoteDto dto){
        return  noteService.updateNote(dto);

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
        return noteService.createNote(dto);
    }



}
