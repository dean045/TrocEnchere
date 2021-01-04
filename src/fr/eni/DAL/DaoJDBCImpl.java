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
			preparedStmt.setInt(10, registration_user.getCredit());
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

	//-------------------------------------------------DELETE--------------------------------------------------------------------------------

	public void delete(Integer no_utilisateur) {

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
					"		mot_de_passe = ?\r\n" + 
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
			preparedStmt.setInt(10, registration_user.getNo_utilisateur());

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

	public List<String> libelle () throws DALException {

		String LIBCATEGORIE= "select libelle from CATEGORIES ;";


		Connection cnx=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		List<String> liste = new ArrayList<String>();


		try {

			cnx= JDBCTOOLS.getConnection();
			pstmt=cnx.prepareStatement(LIBCATEGORIE);
			rs=pstmt.executeQuery();

			while (rs.next()) {
				//creation d'un objet Java
				String lib = rs.getString("libelle");
				liste.add(lib);
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
}  



