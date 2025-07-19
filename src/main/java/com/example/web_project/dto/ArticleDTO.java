package com.example.web_project.dto;

import com.example.web_project.common.Category;
import com.example.web_project.common.Type;
import com.example.web_project.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO {

    @NotBlank(message = "Title bài viết không được để trống")
    private String title;

    @NotBlank(message = "Date bài viết không được để trống")
    private Date date;

    @NotBlank(message = "Content bài viết không được để trống")
    private String content;

    private String image;

    private Type type;

    @NotBlank(message = "Category bài viết không được để trống")
    private Category category;

}
