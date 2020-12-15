package fr.eni.DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.BO.*;
import fr.eni.DAL.JDBCTOOLS;

public class DaoJDBCImpl implements articleDao {
	public List<Articles> selectAll() throws DALException  {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		
		List<Articles> liste = new ArrayList<Articles>();
		try {
			System.out.println("-1");
			//recuperation de la connection g�r� par JdbcTools 
			cnx = JDBCTOOLS.getConnection(); 
			System.out.println("0");
			//creation requete
			rqt = cnx.createStatement();
			System.out.println("1");
			//requete selection de tout les articles
			String SQLSelectAllArticle = "select no_article, nom_article, prix_vente, date_fin_encheres, ARTICLES.no_utilisateur, IMG\r\n" + 
					"From ARTICLES\r\n" + 
					"left join UTILISATEURS ON ARTICLES.no_utilisateur = UTILISATEURS.no_utilisateur AND ARTICLES.ETAT ='EC'; ";
					
			
			//execution requete
			rs = rqt.executeQuery(SQLSelectAllArticle);
			
			
			
			System.out.println("2");
			Articles article;
			
			
			while (rs.next()) {
				//creation d'un objet Java
				int no_article = rs.getInt("no_article");
				String nom = rs.getString("nom_article");
				Date date = rs.getDate("date_fin_encheres");
				article = new Articles(no_article, nom, date , rs.getInt("prix_vente"), 
						rs.getInt("no_utilisateur"), "EC",rs.getString("IMG"));
				liste.add(article);
			}
			System.out.println("3");
			return liste;
			
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		}
		finally{
			try {
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
}


