package com.notetakingapp.notemanagement.service;

import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.entity.User;

import java.util.List;

public interface UserService {
    String createUser(User user);
    String deleteUser(String id);

    String signInUser(User user);

}
