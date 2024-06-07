package com.tp.article.groupe3.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tp.article.groupe3.model.Categorie;

@Repository
public interface CategorieDao extends CrudRepository<Categorie, Integer> {

}