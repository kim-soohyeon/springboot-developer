package me.kimsoohyeon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.kimsoohyeon.springbootdeveloper.domain.Article;
import me.kimsoohyeon.springbootdeveloper.dto.AddArticleRequest;
import me.kimsoohyeon.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
