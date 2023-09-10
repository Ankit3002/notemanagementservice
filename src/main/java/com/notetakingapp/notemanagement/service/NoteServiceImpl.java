package com.notetakingapp.notemanagement.service;

import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.mapper.CreateNoteMapper;
import com.notetakingapp.notemanagement.mapper.UpdateNoteMapper;
import com.notetakingapp.notemanagement.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CreateNoteMapper createNoteMapper;

    @Autowired
    private UpdateNoteMapper updateNoteMapper;

    @Override
    public List<Note> getAllNotes() {

        List<Note> note_list = noteRepository.findAll();
        return note_list;
    }

    @Override
    public String updateNote(updateNoteDto dto) {

        Note note_value = updateNoteMapper.ConvertUpdateDtoToEntity(dto);
        Note saved_note = noteRepository.save(note_value);
        if(saved_note.getId().equals(note_value.getId()))
        {
            return saved_note.getId();
        }
        return null;
    }

    @Override
    public Note getNote(String id) {
        Note note_value = noteRepository.findById(id).get();
        if(note_value.getId().equals(id))
        {
            return note_value;
        }
        return null;
    }

    @Override
    public void deleteNote(String id) {
        noteRepository.deleteById(id);
    }

    @Override
    public String createNote(createNoteDto dto) {
        Note note_value = createNoteMapper.ConvertCreateDtoToEntity(dto);
        note_value.setId(UUID.randomUUID().toString());
        Note savedNote = noteRepository.save(note_value);
        if(savedNote.getId().equals(dto.getId()))
        {
            return savedNote.getId();
        }
        return null;
    }
}
