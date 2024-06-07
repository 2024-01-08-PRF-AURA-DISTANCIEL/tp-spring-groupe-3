package com.tp.article.groupe3.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import com.tp.article.groupe3.dao.ArticleDao;
import com.tp.article.groupe3.model.Article;

@Component
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	public ArticleService() {
	}

	public Article saveOrUpdateArticle(Article article) {
		return articleDao.save(article);
	}

	public void delete(Integer id) {
		Optional<Article> articleOptional = articleDao.findById(id);
		if (articleOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found");
		} else {
			Article article = articleOptional.get();
			articleDao.delete(article);
		}
	}

	/*public List<Article> searchArticlesByName(String nom){
		

	}*/



}
