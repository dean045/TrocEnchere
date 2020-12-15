package fr.eni.BLL;

import java.util.ArrayList;
import java.util.List;

import fr.eni.DAL.DALException;
import fr.eni.DAL.articleDao;
import fr.eni.DAL.DaoFactory;
import fr.eni.BO.Articles;

public class Manager {

	articleDao methode = new DaoFactory().getdao();
	public List<Articles> getliste() throws DALException{
		List<Articles> liste = new ArrayList<Articles>();
		try {
			liste = methode.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
}
