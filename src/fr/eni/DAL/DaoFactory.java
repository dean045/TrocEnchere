package fr.eni.DAL;

import fr.eni.DAL.DaoJDBCImpl;

public class DaoFactory {
	public static articleDao getdao() {
		return new DaoJDBCImpl();
	}
}
