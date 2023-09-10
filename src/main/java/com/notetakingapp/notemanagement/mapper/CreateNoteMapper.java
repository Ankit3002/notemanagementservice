package com.notetakingapp.notemanagement.mapper;

import com.notetakingapp.notemanagement.dto.createNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class CreateNoteMapper {

    // dto to entity...
    public Note ConvertCreateDtoToEntity(createNoteDto dto)
    {
        Note note_value = new Note();
        note_value.setHeading(dto.getHeading());
        note_value.setMessage(dto.getMessage());
        note_value.setId(dto.getId());

        return note_value;
    }


    // entity to dto...

    public createNoteDto ConvertCreateEntityToDto(Note note_value)
    {
        createNoteDto dto = new createNoteDto();
        dto.setHeading(note_value.getHeading());
        dto.setMessage(note_value.getMessage());
        dto.setId(note_value.getId());
        return dto;

    }


}
