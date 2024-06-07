package com.tp.article.groupe3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import com.tp.article.groupe3.dao.CategorieDao;
import com.tp.article.groupe3.model.Categorie;

@Component
public class CategorieService {
	@Autowired
    private CategorieDao categorieDao;

    public CategorieService() {
        super();
    }

    public Categorie get(Integer id) {
        Optional<Categorie> categorieOptional = categorieDao.findById(id);
        if (categorieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune categorie trouvée !!!");
        } else {
            return categorieOptional.get();
        }
    }

    public Categorie save(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    public void delete(Integer id) {
        Optional<Categorie> categorieOptional = categorieDao.findById(id);
        if (categorieOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune categorie trouvée !!");
        } else {
            Categorie categorie = categorieOptional.get();
            if (!categorie.getArticles().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossible de supprimer !!");
            }
            categorieDao.delete(categorie);
        }
    }
}
