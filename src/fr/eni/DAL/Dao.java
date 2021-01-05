package fr.eni.DAL;

import java.util.List;

import fr.eni.BO.*;

public interface Dao {
	public List<Articles> selectAll(int no_categorie) throws DALException;
	public void insert(Utilisateurs registration_user) throws DALException;
	public void insert(Articles registration_item) throws DALException;
	public Utilisateurs login (String username, String pw) throws DALException;
	public Articles select (int noArticle) throws DALException;
	public boolean verfication (String username) throws Exception ;
	public void delete(Integer no_utilisateur)throws DALException;
	public void Update_user(Utilisateurs registration_user) throws DALException;
	public List<String> libelle() throws DALException;
	public Utilisateurs select_user (int no_utilisateur) throws DALException;
	public void Update_article(Articles registration_article) throws DALException;
	
}


