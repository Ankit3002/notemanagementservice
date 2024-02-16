package com.notetakingapp.notemanagement.mapper;

import com.notetakingapp.notemanagement.dto.updateNoteDto;
import com.notetakingapp.notemanagement.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class UpdateNoteMapper {

    // convert dto to entity ...
    public Note ConvertUpdateDtoToEntity(updateNoteDto dto)
    {
        Note note_value = new Note();
        note_value.setId(dto.getId());
        note_value.setHeading(dto.getHeading());
        note_value.setMessage(dto.getMessage());
        note_value.setUser(dto.getUser());

        return note_value;
    }

    // convert entity to dto...
    public updateNoteDto ConvertEntityToUpdateDto(Note note_value)
    {
        updateNoteDto dto = new updateNoteDto();
        dto.setHeading(note_value.getHeading());
        dto.setId(note_value.getId());
        dto.setMessage(note_value.getMessage());
        return dto;
    }



}
