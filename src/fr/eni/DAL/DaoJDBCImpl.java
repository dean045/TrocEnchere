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



public class DaoJDBCImpl implements Dao {




	public List<Articles> selectAll(int no_categorie) throws DALException  {
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
			String sql;

			if(no_categorie == 0)
			{
				sql = "select no_article, nom_article, prix_vente, date_fin_encheres, ARTICLES.no_utilisateur, IMG , UTILISATEURS.pseudo, no_categorie \r\n" + 
						"From ARTICLES\r\n" + 
						"left join UTILISATEURS ON ARTICLES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE ARTICLES.ETAT ='EC'; ";
				//execution requete
				rs = rqt.executeQuery(sql);
			}
			else
			{

				sql = "select no_article, nom_article, prix_vente, date_fin_encheres, ARTICLES.no_utilisateur, IMG, UTILISATEURS.pseudo, no_categorie \r\n" + 
						"From ARTICLES\r\n" + 
						"left join UTILISATEURS ON ARTICLES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE ARTICLES.ETAT ='EC' AND ARTICLES.no_categorie =" + no_categorie + "; ";
				rs = rqt.executeQuery(sql);
			}






			System.out.println("2");
			Articles article;


			while (rs.next()) {
				//creation d'un objet Java
				int no_article = rs.getInt("no_article");
				String nom = rs.getString("nom_article");
				Date date = rs.getDate("date_fin_encheres");
				article = new Articles(no_article, nom, date , rs.getInt("prix_vente"), 
						rs.getInt("no_utilisateur"), "EC",rs.getString("IMG"));
				article.setPseudo(rs.getString("pseudo"));

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


	//------------------INSERT--USER-------------------------------------------------------


	public void insert(Utilisateurs registration_user) throws DALException{
		Statement stmt = null;
		Connection con = null;

		try {
			con = JDBCTOOLS.getConnection();
			//Créer une requete / Statement
			String sql = "INSERT INTO Utilisateurs VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, registration_user.getPseudo());
			preparedStmt.setString(2, registration_user.getNom());
			preparedStmt.setString(3, registration_user.getPrenom());
			preparedStmt.setString(4, registration_user.getEmail());
			preparedStmt.setString(5, registration_user.getTelephone());
			preparedStmt.setString(6, registration_user.getRue());
			preparedStmt.setString(7, registration_user.getCode_postal());
			preparedStmt.setString(8, registration_user.getVille());
			preparedStmt.setString(9, registration_user.getMot_de_passe());
			preparedStmt.setInt(10, 0);
			preparedStmt.setInt(11, registration_user.getAdministrateur());

			//Execute la requete
			preparedStmt.executeUpdate();

			ResultSet rs =   preparedStmt.getGeneratedKeys();

			while(rs.next()) {
				registration_user.setNo_utilisateur(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();			
		} finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//----------------------INSERT--ARTICLE------------------------------------------------

	public void insert(Articles item) throws DALException{
		Statement stmt = null;
		Connection con = null;

		try {
			con = JDBCTOOLS.getConnection();
			//Créer une requete / Statement
			String sql = "INSERT INTO ARTICLES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, item.getNomArticle());
			preparedStmt.setString(2, item.getDescription());
			preparedStmt.setDate(3, item.getDateDebutEnchere());
			preparedStmt.setDate(4, item.getDateFinEnchere());
			preparedStmt.setInt(5, item.getPrixInitial());
			preparedStmt.setInt(6, item.getPrixInitial());
			preparedStmt.setInt(7, item.getNoUtilisateur());
			preparedStmt.setInt(8, 1);
			preparedStmt.setString(9, item.getEtat());
			preparedStmt.setString(10,item.getImg());


			//Execute la requete
			preparedStmt.executeUpdate();

			ResultSet rs =   preparedStmt.getGeneratedKeys();

			while(rs.next()) {
				item.setNoArticle(rs.getInt(1));
			}
			sql = "INSERT INTO RETRAITS VALUES (?, ?, ?, ?)";
			preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, item.getNoArticle());
			preparedStmt.setString(2, item.getRue());
			preparedStmt.setString(3, item.getCode_postal());
			preparedStmt.setString(4, item.getVille());

			preparedStmt.executeUpdate();

			rs =   preparedStmt.getGeneratedKeys();

		} catch (SQLException e) {
			e.printStackTrace();			
		} finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	

	//--------------------SELECT-----------------------------------------------------------


	public Articles select (int noArticle) throws DALException {
		Connection cnx=null;
		Statement pstmt=null;
		ResultSet rs = null;
		Articles art = new Articles ();
		String SELECT = "SELECT * from ARTICLES where no_article = "+ noArticle +";";



		try {
			cnx=JDBCTOOLS.getConnection();
			pstmt=cnx.createStatement();
			rs = pstmt.executeQuery(SELECT);
			System.out.println("test select article ok");
			while (rs.next()){

				art.setNoArticle(rs.getInt("no_article"));

				art.setNomArticle(rs.getString("nom_article"));

				art.setDescription(rs.getString("description"));

				art.setDateDebutEnchere(rs.getDate("date_debut_encheres"));

				art.setDateFinEnchere(rs.getDate("date_fin_encheres"));

				art.setPrixInitial(rs.getInt("prix_initial"));

				art.setPrixVente(rs.getInt("prix_vente"));

				art.setNoUtilisateur(rs.getInt("no_utilisateur"));

				art.setCategorie(rs.getString("no_categorie"));

				art.setEtat("EC");

				art.setImg(rs.getString("IMG"));

				art.setNo_acheteur(rs.getInt("no_acheteur"));
			}
			SELECT = "SELECT * from RETRAITS where no_article = "+ noArticle +";";
			rs = pstmt.executeQuery(SELECT);
			System.out.println("test select retraits ok");
			while(rs.next())
			{
				art.setCode_postal(rs.getString("code_postal"));
				art.setRue(rs.getString("rue"));
				art.setVille(rs.getString("ville"));
			}

		} catch (SQLException e) {

			throw new DALException ("Probleme - obtenirUnUtil - " + e.getMessage());

		}finally{
			try{
				if (pstmt!=null) pstmt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				throw new DALException ("Probleme - FermerConnexion - " + e.getMessage());
			}

		}
		return art;

	}


	//--------------------Login-----------------------------------------------------------


	public Utilisateurs login (String username, String pw) throws DALException
	{
		Connection cnx=null;
		PreparedStatement rqt = null;
		ResultSet rs=null;
		Utilisateurs user = null;
		String SELECT;

		if(username.indexOf('@') !=-1)
			SELECT = "SELECT * from UTILISATEURS where email = ? AND mot_de_passe = ? ;";
		else
			SELECT = "SELECT * from UTILISATEURS where pseudo = ? AND mot_de_passe = ? ;";


		try {
			System.out.println("-1");
			//recuperation de la connection g�r� par JdbcTools 
			cnx = JDBCTOOLS.getConnection(); 
			System.out.println("0");
			//creation requete

			rqt = cnx.prepareStatement(SELECT);
			rqt.setString(1, username);
			rqt.setString(2, pw);
			System.out.println("1");

			//execution requete
			rs = rqt.executeQuery();

			System.out.println("2");

			while (rs.next()) {
				//creation d'un objet Java
				user = new Utilisateurs(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), 
						rs.getString("prenom"), rs.getString("email"),  rs.getString("telephone"),
						rs.getString("rue"),  rs.getString("code_postal"),  rs.getString("ville"), 
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getInt("administrateur"));
			}
			System.out.println("3");


		} catch (SQLException e) {
			throw new DALException("connexion failed - ", e);
		}
		finally{
			try {
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException ("Probleme - FermerConnexion - " + e.getMessage());
			}
		}
		return user;
	}


	//----------------Verification MDP ---------------------------------------------------


	public boolean verfication (String username) throws Exception {

		Connection cnx=null;
		PreparedStatement rqt = null;
		ResultSet rs=null;
		String SELECT;
		boolean check = true ;

		if(username.indexOf('@') !=-1)
			SELECT = "SELECT * from UTILISATEURS where email = ?;";
		else
			SELECT = "SELECT * from UTILISATEURS where pseudo = ?;";


		try {
			System.out.println("-1");
			//recuperation de la connection g�r� par JdbcTools 
			cnx = JDBCTOOLS.getConnection(); 
			System.out.println("0");
			//creation requete

			rqt = cnx.prepareStatement(SELECT);
			rqt.setString(1, username);
			System.out.println("1");

			//execution requete
			rs = rqt.executeQuery();

			System.out.println("2");

			//List<Utilisateurs> listUtil = new ArrayList <Utilisateurs> () ; 
			while (rs.next()){
				check = false ; 
			} 


		} catch (Exception e) {
			throw new Exception("Failure while trying to check is the user is already registered :" + e);
		}
		return check;
	}

	//-------------------------------------------------DELETE-----------------------------

	public void delete(Integer no_utilisateur) throws DALException{

		Connection con = null;

		try {
			con = JDBCTOOLS.getConnection();
			String sql = "DELETE FROM UTILISATEURS WHERE no_utilisateur = "+no_utilisateur+" ";

			Statement stmt = con.createStatement();


			stmt.executeUpdate(sql);


		} catch(SQLException e){

		}
		finally {
			try{
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	


	//----------------Update-user---------------------------------------------------------

	public void Update_user(Utilisateurs registration_user) throws DALException{
		Statement stmt = null;
		Connection con = null;

		try {
			con = JDBCTOOLS.getConnection();
			//Créer une requete / Statement
			String sql = "UPDATE UTILISATEURS SET pseudo = ?,\r\n" + 
					"		nom = ?,\r\n" + 
					"		prenom = ?,\r\n" + 
					"		email = ?,\r\n" + 
					"		telephone = ?,\r\n" + 
					"		rue = ?,\r\n" + 
					"		code_postal = ?,\r\n" + 
					"		ville = ?,\r\n" + 
					"		mot_de_passe = ?,\r\n" + 
					"		credit = ?\r\n" +
					"WHERE no_utilisateur = ?;";


			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, registration_user.getPseudo());
			preparedStmt.setString(2, registration_user.getNom());
			preparedStmt.setString(3, registration_user.getPrenom());
			preparedStmt.setString(4, registration_user.getEmail());
			preparedStmt.setString(5, registration_user.getTelephone());
			preparedStmt.setString(6, registration_user.getRue());
			preparedStmt.setString(7, registration_user.getCode_postal());
			preparedStmt.setString(8, registration_user.getVille());
			preparedStmt.setString(9, registration_user.getMot_de_passe());
			preparedStmt.setInt(10, registration_user.getCredit());
			preparedStmt.setInt(11, registration_user.getNo_utilisateur());

			//Execute la requete
			preparedStmt.executeUpdate();

			ResultSet rs =   preparedStmt.getGeneratedKeys();


		} catch (SQLException e) {
			e.printStackTrace();			
		} finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//------------------------- list Catégorie --------------------------------- 

	public List<Categories> libelle() throws DALException {

		String LIBCATEGORIE= "select * from CATEGORIES ;";


		Connection cnx=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {

			cnx= JDBCTOOLS.getConnection();
			pstmt=cnx.prepareStatement(LIBCATEGORIE);
			rs=pstmt.executeQuery();

			List <Categories> liste = new ArrayList <Categories> () ; 

			Categories cat = new Categories();
			while (rs.next()) {
				cat = new Categories(rs.getInt("no_categorie"),rs.getString("libelle"));
				liste.add(cat);
			}
			System.out.println("Récupération catégorie");
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

	//----------------Select-user---------------------------------------------------------

	public Utilisateurs select_user (int no_utilisateur) throws DALException {
		Connection cnx=null;
		Statement pstmt=null;
		ResultSet rs = null;
		Utilisateurs user = new Utilisateurs();
		String SELECT = "SELECT * from UTILISATEURS where no_utilisateur = "+ no_utilisateur +";";



		try {
			cnx=JDBCTOOLS.getConnection();
			pstmt=cnx.createStatement();
			rs = pstmt.executeQuery(SELECT);
			System.out.println("test select article ok");
			while (rs.next()){

				user.setNo_utilisateur(rs.getInt("no_utilisateur"));

				user.setPseudo(rs.getString("pseudo"));

				user.setNom(rs.getString("nom"));

				user.setPrenom(rs.getString("prenom"));

				user.setEmail(rs.getString("email"));

				user.setTelephone(rs.getString("telephone"));

				user.setRue(rs.getString("rue"));

				user.setCode_postal(rs.getString("code_postal"));

				user.setVille(rs.getString("ville"));

				user.setMot_de_passe(rs.getString("mot_de_passe"));

				user.setCredit(Integer.valueOf(rs.getString("credit")));

				user.setAdministrateur(Integer.valueOf(rs.getString("administrateur")));

			}

		} catch (SQLException e) {

			throw new DALException ("Probleme - obtenirUnUtil - " + e.getMessage());

		}finally{
			try{
				if (pstmt!=null) pstmt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				throw new DALException ("Probleme - FermerConnexion - " + e.getMessage());
			}

		}
		return user;

	}

	//----------------------------Update--article---------------------

	public void Update_article(Articles registration_article) throws DALException{
		Statement stmt = null;
		Connection con = null;

		try {
			con = JDBCTOOLS.getConnection();
			//Créer une requete / Statement
			String sql = "UPDATE ARTICLES SET nom_article = ?,\r\n" + 
					"		description = ?,\r\n" + 
					"		date_debut_encheres = ?,\r\n" + 
					"		date_fin_encheres = ?,\r\n" + 
					"		prix_initial = ?,\r\n" + 
					"		prix_vente = ?,\r\n" + 
					"		no_utilisateur = ?,\r\n" +
					"		no_categorie = ?,\r\n" + 
					"		etat = ?,\r\n" + 
					"		img = ?,\r\n" +
					"		no_acheteur = ? \r\n" +
					"WHERE no_article = ?;";


			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, registration_article.getNomArticle());
			preparedStmt.setString(2, registration_article.getDescription());
			preparedStmt.setDate(3, registration_article.getDateDebutEnchere());
			preparedStmt.setDate(4, registration_article.getDateFinEnchere());
			preparedStmt.setInt(5, registration_article.getPrixInitial());
			preparedStmt.setInt(6, registration_article.getPrixVente());
			preparedStmt.setInt(7, registration_article.getNoUtilisateur());
			preparedStmt.setString(8, registration_article.getCategorie());
			preparedStmt.setString(9, registration_article.getEtat());
			preparedStmt.setString(10,registration_article.getImg());
			preparedStmt.setInt(11,registration_article.getNo_acheteur());
			preparedStmt.setInt(12,registration_article.getNoArticle());


			//Execute la requete
			preparedStmt.executeUpdate();

			ResultSet rs =   preparedStmt.getGeneratedKeys();


		} catch (SQLException e) {
			e.printStackTrace();			
		} finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//----------------------INSERT--ARTICLE------------------------------------------------

	public void enchere(Articles item) throws DALException{
		Statement stmt = null;
		Connection con = null;

		try {
			con = JDBCTOOLS.getConnection();
			//Créer une requete / Statement
			String sql = "INSERT INTO ENCHERES VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, item.getNo_acheteur());
			preparedStmt.setInt(2, item.getNoArticle());
			preparedStmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStmt.setInt(4, item.getPrixVente());


			//Execute la requete
			preparedStmt.executeUpdate();

			ResultSet rs =   preparedStmt.getGeneratedKeys();

		} catch (SQLException e) {
			e.printStackTrace();			
		} finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	


	//-------------------------------------------------DELETE-Art--------------------------
	public void delete_article(int no_article) throws DALException{

		Connection con = null;
		try {
			con = JDBCTOOLS.getConnection();
			String sql = "DELETE FROM ARTICLES WHERE no_article = ? ";
			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.setInt(1, no_article);
			preparedStmt.executeUpdate();

		} catch(SQLException e){

		}
		finally {
			try{
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//-------------------------------------------------refresh--------------------------
	public void refresh() throws DALException{

		Connection con = null;
		try {
			con = JDBCTOOLS.getConnection();
			String sql = "update ARTICLES set ETAT = 'FN' where DATEDIFF(day,date_fin_encheres, GETDATE()) > 0;" +
					"update ARTICLES set ETAT = 'EC' where DATEDIFF(day,date_debut_encheres, GETDATE()) >= 0 AND DATEDIFF(day,date_fin_encheres, GETDATE()) < 0;" +
					"update ARTICLES set ETAT = 'PR' where DATEDIFF(day,date_debut_encheres, GETDATE()) < 0;";
			PreparedStatement preparedStmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStmt.executeUpdate();

		} catch(SQLException e){

		}
		finally {
			try{
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	//-------------------------------------------------Select-Achat--------------------------
	public List<Articles> selectAchat(int no_categorie, int no_etat ,int no_acheteur) throws DALException  {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;

		List<Articles> liste = new ArrayList<Articles>();
		try {
			//recuperation de la connection g�r� par JdbcTools 
			cnx = JDBCTOOLS.getConnection(); 
			//creation requete
			rqt = cnx.createStatement();
			//requete selection de tout les articles
			String cat = new String();
			String etat = "'EC'";
			String sql = new String();
			if(no_categorie == 0) cat = "";
			else cat = " AND ARTICLES.no_categorie =" + no_categorie;
			
			sql = "select no_article, nom_article, prix_vente, date_fin_encheres, ARTICLES.no_utilisateur, IMG, UTILISATEURS.pseudo, no_categorie \r\n" + 
					"From ARTICLES\r\n" + 
					"left join UTILISATEURS ON ARTICLES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE ARTICLES.ETAT ="+ etat + cat ;
			if(no_etat == 2) {
				etat = "'FN'";
				sql = "select distinct ARTICLES.no_article, nom_article, prix_vente, date_fin_encheres, ARTICLES.no_utilisateur, IMG, no_categorie \r\n" + 
						"From ENCHERES\r\n" + 
						"inner join ARTICLES ON ARTICLES.no_article = ENCHERES.no_article WHERE ARTICLES.ETAT = " + etat + " AND ARTICLES.no_acheteur = "+no_acheteur + cat;
				}
			else if(no_etat == 1) {
				sql = "select distinct ARTICLES.no_article, nom_article, prix_vente, date_fin_encheres, ENCHERES.no_utilisateur, IMG, no_categorie \r\n" + 
						"From ARTICLES\r\n" + 
						"inner join ENCHERES ON ENCHERES.no_article  = ARTICLES.no_article and  ENCHERES.no_utilisateur = "+no_acheteur + "where ARTICLES.ETAT = " + etat + cat;
			}
			rs = rqt.executeQuery(sql);

			System.out.println("2");
			Articles article;


			while (rs.next()) {
				//creation d'un objet Java
				int no_article = rs.getInt("no_article");
				String nom = rs.getString("nom_article");
				Date date = rs.getDate("date_fin_encheres");
				article = new Articles(no_article, nom, date , rs.getInt("prix_vente"), 
						rs.getInt("no_utilisateur"), "EC",rs.getString("IMG"));
				if(no_etat == 0) article.setPseudo(rs.getString("pseudo"));
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
	
	//-------------------------------------------------Select-vente--------------------------
		public List<Articles> selectVente(int no_categorie, int no_etat ,int no_utilisateur) throws DALException  {
			Connection cnx = null;
			Statement rqt = null;
			ResultSet rs = null;

			List<Articles> liste = new ArrayList<Articles>();
			try {
				//recuperation de la connection g�r� par JdbcTools 
				cnx = JDBCTOOLS.getConnection(); 
				//creation requete
				rqt = cnx.createStatement();
				//requete selection de tout les articles
				String cat = new String();
				String etat = "'EC'";
				String sql = new String();
				if(no_categorie == 0) cat = "";
				else cat = " AND ARTICLES.no_categorie =" + no_categorie;
				
				if(no_etat == 1) etat ="'PR'";
				else if (no_etat == 2) etat = "'FN'";
				
				sql = "select no_article, nom_article, prix_vente, date_fin_encheres, ARTICLES.no_utilisateur, IMG, UTILISATEURS.pseudo, no_categorie  \r\n" + 
						"From UTILISATEURS\r\n" + 
						"inner join Articles ON ARTICLES.no_utilisateur = UTILISATEURS.no_utilisateur and ARTICLES.no_utilisateur = " + no_utilisateur + " AND ARTICLES.ETAT = "+etat + cat;
				
				
				rs = rqt.executeQuery(sql);

				System.out.println("2");
				Articles article;


				while (rs.next()) {
					//creation d'un objet Java
					int no_article = rs.getInt("no_article");
					String nom = rs.getString("nom_article");
					Date date = rs.getDate("date_fin_encheres");
					article = new Articles(no_article, nom, date , rs.getInt("prix_vente"), 
							rs.getInt("no_utilisateur"), "EC",rs.getString("IMG"));
					article.setPseudo(rs.getString("pseudo"));
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



