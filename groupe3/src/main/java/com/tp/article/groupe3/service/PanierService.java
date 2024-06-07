package com.tp.article.groupe3.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.tp.article.groupe3.dao.LigneCommandeDao;
import com.tp.article.groupe3.dao.PanierDao;
import com.tp.article.groupe3.model.Panier;
import com.tp.article.groupe3.model.Status;
import com.tp.article.groupe3.model.Utilisateur;

public class PanierService {

	@Autowired
	private LigneCommandeDao ligneCommandeDao;

	@Autowired
	private PanierDao panierDao;
	@Autowired
	private UtilisateurService utilisateurService;

	public Panier createNewPanier() {


		Panier panier = new Panier();
		panier.setDate_creation(LocalDateTime.now());
		panier.setStatus(Status.PANIER);

		return panier;

	}

	public void addArticlePanier(int articleId, int userId, int quantite) throws HttpClientErrorException {
		Utilisateur utilisateur = utilisateurService.get(userId);
		if (utilisateur == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
		} 
		Panier panier = panierDao.getPanierByUtilisateur(userId);
		if (panier == null) {
			panier = createNewPanier();
			panier.setUtilisateur(utilisateur);
			panierDao.save(panier);

		}
		boolean existsProduct = false;
		/***
		 * for ( LigneCommande ligneCommande: panier.getLignesCommande()) {
		 * 
		 * 
		 * if(ligneCommande.getArticleId().getId() == articleId) {
		 * ligneCommande.getArticle().setQuantite(ligneCommande.getArticle().getQuantite()
		 * + quantite); existsProduct = true; break; }
		 * 
		 * }
		 * 
		 * if (!existsProduct) { LigneCommande ligneCommande = new LigneCommande();
		 * ligneCommande.setArticleId(articleId); ligneCommande.setQuantite(quantite);
		 * 
		 * ligneCommande.setPanierId(panier.getId());
		 * ligneCommandeDao.save(ligneCommande);
		 * 
		 * }
		 */

		


	}

	public Panier get(int id) throws HttpClientErrorException {

		Optional<Panier> OptionalPanier = panierDao.findById(id);
		if (OptionalPanier.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No panier found");
		} else {
			Panier panier = OptionalPanier.get();
			return panier;
		}
		}

		/***
		 * public Utilisateur validatePanier(int utilisateurId) throws
		 * HttpClientErrorException { Panier panier =
		 * panierDao.getPanierByUtilisateur(utilisateurId);
		 * 
		 * if (panier == null) { // throw new ResponseStatusException(HttpStatus., "Cet
		 * utilisateur n'a aucun // panier au status panier");
		 * 
		 * } else {
		 * 
		 * 
		 * 
		 * }
		 * 
		 * }
		 */
}
