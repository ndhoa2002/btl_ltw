package com.example.web_project.repository;

import com.example.web_project.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.web_project.common.Field;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByIsAnsweredTrue();
    List<Feedback> findByField(Field field);
}
