package org.example.ch05.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch05.domain.Article;
import org.example.ch05.dto.AddArticleRequest;
import org.example.ch05.dto.ArticleResponse;
import org.example.ch05.dto.UpdateArticleRequest;
import org.example.ch05.repository.ArticleRepository;
import org.example.ch05.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // 생성자 자동으로 주입 되게
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/api/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articleResponseList =
                blogService.findAll().stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(articleResponseList);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {

        // Article 객체를 생성 후 응답
        Article article = blogService.save(addArticleRequest);
        // return ResponseEntity.ok(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);
        return ResponseEntity.ok().body(updateArticle);
    }
}
