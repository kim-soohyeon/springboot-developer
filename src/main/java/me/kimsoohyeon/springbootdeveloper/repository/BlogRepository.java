package me.kimsoohyeon.springbootdeveloper.repository;

import me.kimsoohyeon.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
