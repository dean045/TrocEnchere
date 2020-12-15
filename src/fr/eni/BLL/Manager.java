package fr.eni.BLL;

import java.util.ArrayList;
import java.util.List;

import fr.eni.DAL.DALException;
import fr.eni.DAL.articleDao;
import fr.eni.DAL.DaoFactory;
import fr.eni.BO.Articles;
import fr.eni.BO.Utilisateurs;

public class Manager {

	articleDao methode = new DaoFactory().getdao();
	
//----------------affichage--list--article--------------
	
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
	
//---------------insert--user----------------------------
	
	public void add_user(Utilisateurs user) throws DALException
	{		
		methode.insert(user); 
	}
}
