package org.example.ch05.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ch05.domain.Article;
import org.example.ch05.dto.AddArticleRequest;
import org.example.ch05.dto.UpdateArticleRequest;
import org.example.ch05.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final ArticleRepository articleRepository;

    public Article save(AddArticleRequest request, String userName) {
        // db에 request 담긴 값을 Article 테이블에 등록
        return articleRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(long id) {
        return articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found : "+ id));
    }

    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found :"+ id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
