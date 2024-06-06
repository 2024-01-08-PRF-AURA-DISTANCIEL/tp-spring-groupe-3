package com.tp.article.groupe3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp.article.groupe3.model.Utilisateur;
import com.tp.article.groupe3.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
	private UtilisateurService utilisateurService;

    public UtilisateurController() {
    }

    @GetMapping("/{id}")
	public Utilisateur getById(@PathVariable("id") Integer id) {
		return utilisateurService.get(id);
	}
	
	@PostMapping
	public Utilisateur save(@RequestBody Utilisateur utilisateur) {
		utilisateurService.save(utilisateur);
		return utilisateur;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		utilisateurService.delete(id);
	}
}