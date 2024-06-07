package com.tp.article.groupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.article.groupe3.model.Article;
import com.tp.article.groupe3.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
  
    @Autowired 
    private ArticleService articleService;

    public ArticleController() {
    }

    @PostMapping
    public ResponseEntity<Article> createOrUpdateArticle(@RequestBody Article article) { 
        return ResponseEntity.ok(articleService.saveOrUpdateArticle(article));
    }
   
	// GetMapping("/search") public ResponseEntity<List<Article>>
	// searchArticlesByName(@PathVariable("nom") String nom) {
	// return ResponseEntity.ok(articleService.searchArticlesByName(nom));
	// }
   
    @DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		articleService.delete(id);
	}
}