package com.notetakingapp.notemanagement.repository;


import com.notetakingapp.notemanagement.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.notetakingapp.notemanagement.entity.User;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
  
  // call the method to fetch notes associated with particular user..
//      List<Note> fetchByUser(User user);

}
