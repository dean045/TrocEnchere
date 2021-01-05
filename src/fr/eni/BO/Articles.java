package fr.eni.BO;

import java.sql.Date;

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
	private String rue ;
	private String code_postal;
	private String ville;
	private int no_acheteur;
	private String pseudo; 




	//Constructeur


	public Articles(int noArticle, String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
			int prixInitial, int prixVente, int noUtilisateur, String etat, String img, String categorie, String rue,
			String code_postal, String ville, int no_acheteur) {
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
		this.categorie = categorie;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.no_acheteur = no_acheteur;
	}

	//Surcharge 
	public Articles(String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere, int prixInitial,
			int noUtilisateur, String etat, String img, String categorie, String rue, String code_postal, String ville) {

		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		this.etat = etat;
		this.img = img;
		this.categorie = categorie;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	
	public Articles(int noArticle, String nomArticle, Date dateFinEnchere, int prixVente, int noUtilisateur,
			String etat, String img) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.dateFinEnchere = dateFinEnchere;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.etat = etat;
		this.img = img;
	}

	public Articles() {
		super();
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNo_acheteur() {
		return no_acheteur;
	}

	public void setNo_acheteur(int no_acheteur) {
		this.no_acheteur = no_acheteur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}




}
