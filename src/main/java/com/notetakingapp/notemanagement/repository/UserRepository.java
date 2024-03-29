package com.notetakingapp.notemanagement.repository;

import com.notetakingapp.notemanagement.entity.Note;
import com.notetakingapp.notemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String name);
}
