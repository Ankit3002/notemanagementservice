package com.notetakingapp.notemanagement.controller;


import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.entity.User;
import com.notetakingapp.notemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    //create the user ...
    @PostMapping
    public String CreateUser(@RequestBody User user)
    {
         return  userService.createUser(user);
    }

    // delete the user...
    @PostMapping("/{userId}")
    public void DeleteUser(@PathVariable("userId") String id)
    {
       userService.deleteUser(id);
    }

    // sigin the user...
    @PostMapping("/signin")
    public String SignInUser(@RequestBody User user)
    {
        return userService.signInUser(user);
    }



}
