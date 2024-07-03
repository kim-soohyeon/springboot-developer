package me.kimsoohyeon.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.kimsoohyeon.springbootdeveloper.domain.Article;
import me.kimsoohyeon.springbootdeveloper.dto.ArticleListViewResponse;
import me.kimsoohyeon.springbootdeveloper.dto.ArticleResponse;
import me.kimsoohyeon.springbootdeveloper.dto.ArticleViewResponse;
import me.kimsoohyeon.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}
