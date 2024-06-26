package com.tp.article.groupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.article.groupe3.model.Panier;
import com.tp.article.groupe3.service.PanierService;

@RestController
@RequestMapping("/panier")
public class PanierController {

	@Autowired
	PanierService panierService;

	public PanierController() {
	}
	
	@PostMapping("/add/{idArticle}/{idUser}/{quantite}")
	public void addArticle(@PathVariable("idArticle") int idArticle, @PathVariable("idUser") int idUser,
			@PathVariable("quantite") int quantite) {
		panierService.addArticlePanier(idArticle, idUser, quantite);

	}

	@PostMapping("/validate/{idUser}")
	public Panier validatePanier(@PathVariable("idUser") int idUser){
		return panierService.validatePanier(idUser);
	}


}
	

