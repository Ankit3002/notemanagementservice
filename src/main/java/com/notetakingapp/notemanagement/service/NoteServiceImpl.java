package com.notetakingapp.notemanagement.service;

import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.entity.User;
import com.notetakingapp.notemanagement.mapper.CreateNoteMapper;
import com.notetakingapp.notemanagement.mapper.UpdateNoteMapper;
import com.notetakingapp.notemanagement.repository.NoteRepository;
import com.notetakingapp.notemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CreateNoteMapper createNoteMapper;

    @Autowired
    private UpdateNoteMapper updateNoteMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Note> getAllNotes() {
        
//        List<Note> fetched_notes = noteRepository.fetchByUser(user);
//        return fetched_notes;
        
        List<Note> note_list = noteRepository.findAll();
        return note_list;
    }

    @Override
    public String updateNote(updateNoteDto dto) {

        Note note_value = updateNoteMapper.ConvertUpdateDtoToEntity(dto);

        // check whether note exist in the repo or not..
        Optional<Note> note =  noteRepository.findById(note_value.getId());
        if(note.isPresent())
        {
            Note saved_note = noteRepository.save(note_value);
            return "Updated";
        }
        else
        {
            return "Not Exist";
        }
    }

    @Override
    public Note getNote(String id) {
        // check in the database whether exist or not ..
        Optional<Note> note =  noteRepository.findById(id);
        if(note.isPresent())
            return note.get();
        else
            return null;

    }

    @Override
    public String deleteNote(String id) {

        Optional<Note> note = noteRepository.findById(id);
        if(note.isPresent())
        {
            noteRepository.deleteById(id);
            return "success";
        }

        return "doesn't exist";
    }

    @Override
    public String createNote(createNoteDto dto) {
        Note note_value = createNoteMapper.ConvertCreateDtoToEntity(dto);
        note_value.setId(UUID.randomUUID().toString());

        Optional<User> fetchUser = userRepository.findById(dto.getUser().getName());
        if(fetchUser.isPresent())
        {
            Note savedNote = noteRepository.save(note_value);
            return "success";
        }
        else
        {
            return "User don't exist for the note";
        }

    }

    @Override
    public List<Note> getAllNoteUser(User user) {
//        List<Note> note_list;
        List<Note> note_list = noteRepository.findAll();
        List<Note> final_list = new ArrayList<>();
        for(int i=0;i<note_list.size();i++)
        {
            if(note_list.get(i).getUser().getName().equals(user.getName()))
            {
                final_list.add(note_list.get(i));
            }
        }

        return final_list;

    }
}
