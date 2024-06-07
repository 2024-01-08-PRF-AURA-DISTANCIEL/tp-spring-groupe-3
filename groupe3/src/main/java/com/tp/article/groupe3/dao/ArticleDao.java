package com.tp.article.groupe3.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tp.article.groupe3.model.Article;

@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {
	List<Article> findByNomContainingIgnoreCase(String nom);
}