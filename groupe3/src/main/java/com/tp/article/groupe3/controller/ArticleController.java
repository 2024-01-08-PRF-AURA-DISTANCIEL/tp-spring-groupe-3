/**
 * package com.tp.article.groupe3.controller;
 * 
 * import com.tp.article.groupe3.model.Article; import
 * com.tp.article.groupe3.service.ArticleServiceImpl; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import java.util.List;
 * 
 * @RestController @RequestMapping("/articles") public class ArticleController {
 * 
 * @Autowired private final ArticleServiceImpl articleService;
 * 
 *            public ArticleController(ArticleServiceImpl articleService) {
 *            this.articleService = articleService; }
 * 
 * @PostMapping public ResponseEntity<Article>
 *              createOrUpdateArticle(@RequestBody Article article) { return
 *              ResponseEntity.ok(articleService.saveOrUpdateArticle(article));
 *              }
 * 
 *              @GetMapping("/{id}") public ResponseEntity<List<Article>>
 *              getAllArticles(@PathVariable String id) { return
 *              ResponseEntity.ok(articleService.getAllArticles()); }
 * 
 *              @GetMapping("/search") public ResponseEntity<List<Article>>
 *              searchArticlesByName(@RequestParam String nom) { return
 *              ResponseEntity.ok(articleService.getArticleByName(nom)); }
 * 
 *              @DeleteMapping("/{id}")
 * 
 *              }
 * 
 * 
 */