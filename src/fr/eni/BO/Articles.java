package fr.eni.BO;

import java.util.Date;

public class Articles {
	
	
	//Attribut 
	private int noArticle ; 
	private String nomArticle ; 
	private String description ; 
	private Date dateDebutEnchere ; 
	private Date dateFinEnchere ; 
	private int prixInitial ; 
	private int prixVente ;
	private int noUtilisateur ; 
	private String etat ; 
	private String img ;
	private String categorie ; 
	private String retrait ; 


	
	
	//Constructeur
	public Articles(int noArticle, String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
					int prixInitial, int prixVente, int noUtilisateur, String etat, String img, String categorie, String retrait) {
		
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.etat = etat;
		this.img = img;
		this.categorie = categorie ; 
		this.retrait = retrait ;

	}

	//Surcharge 
	public Articles(String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere, int prixInitial,
			int prixVente, int noUtilisateur, String etat, String img, String categorie, String retrait) {
				
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.etat = etat;
		this.img = img;
		this.categorie = categorie ;
		this.retrait = retrait ;
	}
    
	
	public Articles(int noArticle, String nomArticle, Date dateFinEnchere, int prixVente, int noUtilisateur, String etat, String img) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.dateFinEnchere = dateFinEnchere;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.etat = etat;
		this.img = img;
	}

	//Getter & Setter 
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
		
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getRetrait() {
		return retrait;
	}

	public void setRetrait(String retrait) {
		this.retrait = retrait;
	} 
	

}
