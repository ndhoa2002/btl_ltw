package com.example.web_project.service;

import com.example.web_project.common.Type;
import com.example.web_project.dto.ArticleDTO;
import com.example.web_project.entity.Article;
import com.example.web_project.entity.User;
import com.example.web_project.exception.ResourceNotFoundException;
import com.example.web_project.repository.ArticleRepository;
import com.example.web_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Article createArticle(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article updateArticle(Long id, ArticleDTO articleDTO) {
        Article currentArticle = articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bài viết không tồn tại"));
        if (currentArticle != null) {
            currentArticle = modelMapper.map(articleDTO, Article.class);
        }
        return articleRepository.save(currentArticle);
    }

    public void deleteArticle(Long id) {
        articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bài viết không tồn tại"));
        articleRepository.deleteById(id);
    }

}
