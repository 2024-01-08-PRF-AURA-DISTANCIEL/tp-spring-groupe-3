package com.tp.article.groupe3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tp.article.groupe3.model.Article;

public interface ArticleDao extends CrudRepository<Article, Integer> {
	@Query("SELECT quantite from article where id = :articleId")
	public int getStockForArticle(@Param("articleId") int articleId);

	@Query("UPDATE article SET quantite = :quantite WHERE id = :articleId")
	public void updateStockForArticle(@Param("articleId") int articleId, @Param("quantite") int quantite);

	List<Article> findByNomContainingIgnoreCase(String nom);

}