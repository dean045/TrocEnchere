package fr.eni.DAL;

import java.util.List;

import fr.eni.BO.*;

public interface articleDao {
	public List<Articles> selectAll() throws DALException;
}
