package com.notetakingapp.notemanagement.service;

import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.entity.User;

import com.notetakingapp.notemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.notetakingapp.notemanagement.service.UserService;
import javax.swing.text.html.Option;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteService noteService;


    @Override
    public String createUser(User user) {
        Optional<User> existUser = userRepository.findById(user.getName());
        if(existUser.isPresent())
            return "failure";
        else
        {
            User savedUser = userRepository.save(user);
            return savedUser.getName();
        }
    }

    @Override
    public void deleteUser(String id) {

        // first delete the notes from the note repository...
        List<Note> noteList = noteService.getAllNotes();
        for(int i=0;i<noteList.size();i++)
        {
            // call the delete api to delete all the notes associated with that particular user ..
            if(noteList.get(i).getUser().getName().equals(id))
            {
            noteService.deleteNote(noteList.get(i).getId());

            }
        }

        userRepository.deleteById(id);

    }

    @Override
    public String signInUser(User user) {

        // check in the database;
        Optional<User> exitUser = userRepository.findById(user.getName());
        if(exitUser.isPresent())
        {
            // yes present...
            if(user.getPassword().equals(exitUser.get().getPassword()))
            {
                return "Correct";
            }
            else
            {
                // incorrect password...
                return "Invalid_Password";
            }
        }
        else
        {
            // not present...
            return "User_Dont_exist";
        }

    }

}
