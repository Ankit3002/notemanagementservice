package com.notetakingapp.notemanagement.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class createNoteDto {
    private String id;


    private String heading ;

    private String message;


}
