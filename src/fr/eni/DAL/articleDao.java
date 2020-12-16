package fr.eni.DAL;

import java.util.List;

import fr.eni.BO.*;

public interface articleDao {
	public List<Articles> selectAll() throws DALException;
	public void insert(Utilisateurs registration_user) throws DALException;
	public void insert(Articles registration_item) throws DALException;
}
