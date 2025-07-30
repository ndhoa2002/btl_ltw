package com.example.web_project.entity;


import com.example.web_project.common.Field;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private Boolean isAnswered;

    private String answer;

    private LocalDateTime questionTime;

    private LocalDateTime answerTime;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"articles", "feedbacks", "password"})
    private User user;

}
