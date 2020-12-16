package fr.eni.DAL;

import java.util.List;

import fr.eni.BO.*;

public interface Dao {
	public List<Articles> selectAll() throws DALException;
	public void insert(Utilisateurs registration_user) throws DALException;
	public void insert(Articles registration_item) throws DALException;
	public Utilisateurs login (String username, String pw) throws DALException;
	public Articles select (int noArticle) throws DALException;
}
