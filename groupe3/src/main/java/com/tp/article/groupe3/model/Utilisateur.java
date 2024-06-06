package com.tp.article.groupe3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	@OneToMany(mappedBy = "utilisateur")
	private List<Panier> paniersDeLUtilisateur = new ArrayList<>();
	private int pointsFidelite;

	public Utilisateur() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Panier> getPaniersDeLUtilisateur() {
		return paniersDeLUtilisateur;
	}

	public void setPaniersDeLUtilisateur(List<Panier> paniersDeLUtilisateur) {
		this.paniersDeLUtilisateur = paniersDeLUtilisateur;
	}

	public int getPointsFidelite() {
		return pointsFidelite;
	}

	public void setPointsFidelite(int pointsFidelite) {
		this.pointsFidelite = pointsFidelite;
	}

}
