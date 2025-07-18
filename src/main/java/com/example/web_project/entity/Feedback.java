package com.example.web_project.entity;


import com.example.web_project.common.Field;
import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private String personalId;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Field field;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
