package com.example.web_project.entity;


import com.example.web_project.common.Category;
import com.example.web_project.common.Type;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date date;

    private String content;

    private String author;

    private String image;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
