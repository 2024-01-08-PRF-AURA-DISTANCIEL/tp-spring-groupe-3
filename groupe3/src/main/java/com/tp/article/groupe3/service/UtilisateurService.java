package com.tp.article.groupe3.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import com.tp.article.groupe3.dao.UtilisateurDao;
import com.tp.article.groupe3.model.Utilisateur;

@Component
public class UtilisateurService {

    @Autowired
	private UtilisateurDao utilisateurDao;

    public UtilisateurService() {
        super();
    }

	public Utilisateur get(Integer id) {
		System.out.println("Je dois récupérer l'utilisateur avec l'id : " + id);
		Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(id);
		if (utilisateurOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
		} else {
			Utilisateur utilisateur = utilisateurOptional.get();
			return utilisateur;
		}
	}

	public Utilisateur save(Utilisateur utilisateur) {
		String message = "Je sauvegarde : " + utilisateur.getId();
		System.out.println(message);
		return utilisateurDao.save(utilisateur);
	}

	public String delete(Integer id) {
		String message = "Je supprime l'utilisateur avec l'id : " + id;
		Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(id);
		if (utilisateurOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
		} else {
			Utilisateur utilisateur = utilisateurOptional.get();
			utilisateurDao.delete(utilisateur);
		}
		System.out.println(message);
		return message;
	}
}