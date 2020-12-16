package fr.eni.DAL;

import fr.eni.DAL.DaoJDBCImpl;

public class DaoFactory {
	public static Dao getdao() {
		return new DaoJDBCImpl();
	}
}
