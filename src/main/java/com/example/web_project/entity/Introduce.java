package com.example.web_project.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "introduce")
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
