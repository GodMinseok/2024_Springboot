package org.example.ch05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ch05.domain.Article;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ArticleResponse {

    private Long id;
    private String title;
    private String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
