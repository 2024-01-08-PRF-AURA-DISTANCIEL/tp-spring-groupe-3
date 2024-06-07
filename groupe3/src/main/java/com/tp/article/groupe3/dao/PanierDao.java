package com.tp.article.groupe3.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tp.article.groupe3.model.Panier;

@Repository
public interface PanierDao extends CrudRepository<Panier, Integer> {

	 @Query("SELECT p from Panier p JOIN Utilisateur u where u.id = :utilisateurId AND status = 1")
	 public Panier getPanierByUtilisateur(@Param("utilisateurId") int utilisateurId);

}