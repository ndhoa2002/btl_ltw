package com.example.web_project.service;

import com.example.web_project.dto.AnswerDTO;
import com.example.web_project.dto.QuestionDTO;
import com.example.web_project.entity.Feedback;
import com.example.web_project.entity.User;
import com.example.web_project.exception.ResourceNotFoundException;
import com.example.web_project.repository.FeedbackRepository;
import com.example.web_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final ModelMapper modelMapper;
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public Feedback createFeedback(QuestionDTO questionDTO) {
        Feedback feedback = modelMapper.map(questionDTO, Feedback.class);
        feedback.setIsAnswered(false);
        feedback.setQuestionTime(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    public Feedback answerFeedback(Long id , AnswerDTO answerDTO) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new  ResourceNotFoundException("câu hỏi không tồn tại"));
        if(feedback != null){
            feedback.setAnswer(answerDTO.getAnswer());
            feedback.setIsAnswered(true);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName(); // đây là username
            User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found"));
            feedback.setAnswerTime(LocalDateTime.now());
            feedback.setUser(user);
        }
        return feedbackRepository.save(feedback);
    }
}
