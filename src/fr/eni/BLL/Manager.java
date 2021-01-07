package fr.eni.BLL;

import java.util.ArrayList;
import java.util.List;

import fr.eni.DAL.DALException;
import fr.eni.DAL.Dao;
import fr.eni.DAL.DaoFactory;
import fr.eni.BO.Articles;
import fr.eni.BO.Categories;
import fr.eni.BO.Utilisateurs;

public class Manager {

	Dao methode = DaoFactory.getdao();

	//----------------affichage--list--article--------------

	public List<Articles> getliste(int no_categorie) throws DALException{
		List<Articles> liste = new ArrayList<Articles>();
		try {
			liste = methode.selectAll(no_categorie);
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

	//---------------insert--item----------------------------

	public void add_item(Articles item) throws DALException
	{		
		methode.insert(item); 
	}	

	//---------------Connexion--------------------------------

	public Utilisateurs connexion(String username, String pw) throws DALException
	{	
		Utilisateurs user = methode.login(username, pw);
		return user;
	}

	//---------------Select-Article---------------------------

	public Articles getArticle(int noArticle) throws DALException
	{	
		Articles art = methode.select(noArticle);
		return art;
	}	
	//----------------Check adresse mail & pseudo-----------------------
	public boolean check (String username) throws Exception {
		return methode.verfication(username);

	}

	//---------------------Delete----------------------------------------

	public void removeUtilisateur(int index) throws Exception{
		try {
			methode.delete(index);
		}catch(DALException e){
			throw new Exception(e.getMessage());
		}
	}

	//---------------------Modifier-user---------------------------------

	public void modifierUtilisateur(Utilisateurs user) throws DALException{
		methode.Update_user(user);
	}

	//---------------------get-user--------------------------------------

	public Utilisateurs getUser (int no_utilisateur) throws DALException{
		return methode.select_user(no_utilisateur);
	}

	//---------------------get-cat--------------------------------------

	public List<Categories> getLibelle ()throws DALException{
		return methode.libelle();

	}

	//--------------------modifier---article---------------------------

	public void modifierArticle(Articles article) throws DALException{
		methode.Update_article(article);
	}

	//--------------------Put-Enchere----------------------------------	
	public void put_enchere(Articles item) throws DALException{
		methode.enchere(item);
	}

	//--------------------delete-art-------------------------------
	public void delete_art(int no_article) throws DALException{
		methode.delete_article(no_article);
	}

	//--------------------Refresh-art-------------------------------
	public void refresh_art() throws DALException{
		methode.refresh();
		}
	//--------------------select-achat-------------------------------
	public List<Articles> select_achat(int no_categorie, int no_etat, int no_acheteur) throws DALException{
			return methode.selectAchat(no_categorie, no_etat, no_acheteur);
			}
	//--------------------select-vente------------------------------
		public List<Articles> select_vente(int no_categorie, int no_etat, int no_utilisateur) throws DALException{
				return methode.selectAchat(no_categorie, no_etat, no_utilisateur);
				}

	}


