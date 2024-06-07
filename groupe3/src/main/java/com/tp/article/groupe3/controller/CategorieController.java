package com.tp.article.groupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp.article.groupe3.model.Categorie;
import com.tp.article.groupe3.service.CategorieService;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
	@Autowired
    private CategorieService categorieService;

    public CategorieController() {
    }

    @GetMapping("/{id}")
    public Categorie getById(@PathVariable("id") Integer id) {
        return categorieService.get(id);
    }

    @PostMapping
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        categorieService.delete(id);
    }
}
