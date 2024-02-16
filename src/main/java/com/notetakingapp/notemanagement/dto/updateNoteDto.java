package com.notetakingapp.notemanagement.dto;

import com.notetakingapp.notemanagement.entity.User;
import lombok.Data;

@Data
public class updateNoteDto {

    private String id;
    private String heading;
    private String message;
    private User user;

}
