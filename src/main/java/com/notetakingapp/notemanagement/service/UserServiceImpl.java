package com.notetakingapp.notemanagement.service;

import com.notetakingapp.notemanagement.entity.User;

import com.notetakingapp.notemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public String createUser(User user) {
//        Note note_value = createNoteMapper.ConvertCreateDtoToEntity(dto);
        user.setId(UUID.randomUUID().toString());
//        note_value.setId(UUID.randomUUID().toString());
        User savedUser = userRepository.save(user);
        if(savedUser.getId().equals(user.getId()))
        {
            return savedUser.getId();
        }
        return null;

    }

    @Override
    public String deleteUser(String id) {

        userRepository.deleteById(id);
        return id;
//        return null;
    }

    @Override
    public String signInUser(User user) {

        User existingUser = userRepository.findByName(user.getName());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // User found and password matches, consider the user signed in
            return "Sign in successful";
        } else {
            // User not found or password doesn't match, consider the sign-in failed
            return "Invalid credentials";
        }

    }


}
