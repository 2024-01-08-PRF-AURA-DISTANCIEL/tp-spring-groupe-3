package com.tp.article.groupe3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantite;
	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;
	@ManyToOne
	@JoinColumn(name = "panier_id")
	private Panier panier;
	
	public LigneCommande() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}


}
