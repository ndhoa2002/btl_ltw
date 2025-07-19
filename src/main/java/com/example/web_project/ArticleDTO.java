package com.example.web_project;

import com.example.web_project.common.Category;
import com.example.web_project.common.Type;
import com.example.web_project.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO {
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

    private Long userID;
}
