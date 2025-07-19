package com.example.web_project.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "introduce")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Introduce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grade;

    private String name;

    private Integer birthYear;

    private String ethnicGroup;

    private String homeTown;

    private String position;
}
