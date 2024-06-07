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
	private int articleId;
	@ManyToOne
	@JoinColumn(name = "panier_id")
	private int panierId;
	
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

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getPanier() {
		return panierId;
	}

	public void setPanierId(int panierId) {
		this.panierId = panierId;
	}
	


}
