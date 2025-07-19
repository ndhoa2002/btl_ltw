package com.example.web_project.service;

import com.example.web_project.ArticleDTO;
import com.example.web_project.entity.Article;
import com.example.web_project.entity.User;
import com.example.web_project.repository.ArticleRepository;
import com.example.web_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Article createArticle(ArticleDTO articleDTO) {
        User user = userRepository.findById(articleDTO.getUserID()).orElse(null);
        Article article = modelMapper.map(articleDTO, Article.class);
        article.setUser(user);
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article updateArticle(long id, Article article) {
        Article currentArticle = articleRepository.findById(id).orElse(null);
        if (currentArticle != null) {
            currentArticle = modelMapper.map(article, Article.class);
        }
        return currentArticle;
    }

    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }

}
