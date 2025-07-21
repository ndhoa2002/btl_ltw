package com.example.web_project.controller;


import com.example.web_project.dto.ArticleDTO;
import com.example.web_project.entity.Article;
import com.example.web_project.service.ArticleService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ServletContext servletContext;
    private final ArticleService articleService;

    @GetMapping
    public List<Article> getArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Article addArticle(@RequestBody @Valid Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return articleService.updateArticle(id, articleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @PostMapping("/upload")
    public Map<String, String> uploadImage(@RequestParam("upload") MultipartFile file) throws IOException {
//        String uploadDir = "/images/";
//        Files.createDirectories(Paths.get(uploadDir));
//
//        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
//        Path target = Paths.get(uploadDir, fileName);
//        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        String rootPath = this.servletContext.getRealPath("/resources/images");
        String fileName = "";

        try {
            byte[] bytes = file.getBytes();

            File dir = new File(rootPath);
            if(!dir.exists())
                dir.mkdirs();

            fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

//        return ResponseEntity.ok(Map.of("url", "http://localhost:8080/images/" + fileName)).getBody();
//        return Map.of("url", "http://localhost:8080/images/" + fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("url", "http://localhost:8080/images/" + fileName)).getBody();

    }
}
