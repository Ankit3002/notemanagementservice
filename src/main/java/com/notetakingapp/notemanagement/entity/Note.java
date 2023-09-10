package com.notetakingapp.notemanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "note_table")
public class Note {
    @Id
    private String id;
    @Column(nullable = false)
    private String heading;
    private String message;


}
