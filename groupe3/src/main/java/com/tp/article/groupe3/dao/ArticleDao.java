package com.tp.article.groupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.article.groupe3.model.Article;

public interface ArticleDao extends JpaRepository<Article, Long> {
	List<Article> findByNameContainingIgnoreCase(String nom);
}