package com.example.web_project.controller;


import com.example.web_project.ArticleDTO;
import com.example.web_project.entity.Article;
import com.example.web_project.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<Article> getArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Article addArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.createArticle(articleDTO);
    }

    @PostMapping("/{id}")
    public Article updateArticle(@PathVariable long id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
    }
}
