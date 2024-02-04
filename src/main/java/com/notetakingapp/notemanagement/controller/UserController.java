package com.notetakingapp.notemanagement.controller;


import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.entity.User;
import com.notetakingapp.notemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    //create the user ...
    @PostMapping
    public String CreateUser(@RequestBody User user)
    {
//        String id =  noteService.createNote(dto);
        String id = userService.createUser(user);
        if(id != null)
        {
            return id;
        }
        return null;
    }

    // delete the user...
    @PostMapping("/{userId}")
    public String DeleteUser(@PathVariable("userId") String id)
    {
//        String deleted_id = noteService.deleteNote(id);
        String deleted_id = userService.deleteUser(id);
        if(deleted_id.equals(id))
            return deleted_id;
        else
            return null;
    }

    // sigin the user...
    @PostMapping("/signin/{userId}")
    public String SignInUser(@RequestBody User user)
    {
        return userService.signInUser(user);
    }



}
