package com.notetakingapp.notemanagement.dto;

import com.notetakingapp.notemanagement.entity.User;
import lombok.Data;

import java.util.UUID;

@Data
public class createNoteDto {
    private String id;
    private String heading;
    private String message;
    private User user;

}
