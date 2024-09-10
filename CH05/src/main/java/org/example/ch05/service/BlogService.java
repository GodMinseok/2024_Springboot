package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.domain.Article;
import org.example.ch05.dto.AddArticleRequest;
import org.example.ch05.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final ArticleRepository articleRepository;

    public Article save(AddArticleRequest request) {
        // db에 request 담긴 값을 Article 테이블에 등록
        articleRepository.save(request.toEntity());
    }
}
