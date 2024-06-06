package com.tp.article.groupe3.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tp.article.groupe3.model.Utilisateur;

@Repository
public interface UtilisateurDao extends CrudRepository<Utilisateur, Integer> {

}