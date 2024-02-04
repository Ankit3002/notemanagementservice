package com.notetakingapp.notemanagement.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_table")
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;

}
