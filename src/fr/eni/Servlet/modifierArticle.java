package fr.eni.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.BLL.Manager;
import fr.eni.BO.Articles;
import fr.eni.BO.Categories;
import fr.eni.DAL.DALException;

/**
 * Servlet implementation class modifierArticle
 */
@WebServlet("/modifierArticle")
public class modifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private HttpSession session;
	Manager manager = new Manager();
	String message;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rd = request.getRequestDispatcher("WEB-INF/modifierArticle.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		Articles article = new Articles();

		if(request.getParameter("button").charAt(0) == 'm'){
			int noArticle = Integer.valueOf(request.getParameter("button").substring(1));
			List<Categories> listeCat = new ArrayList<Categories>();

			try {
				article = manager.getArticle(noArticle);
				listeCat = manager.getLibelle();
				request.setAttribute("article", article);
				request.setAttribute("listeCat", listeCat);
			} catch (DALException e) {

				e.printStackTrace();
			}


			rd = request.getRequestDispatcher("WEB-INF/modifierArticle.jsp");
			rd.forward(request, response);
		}

		else if(request.getParameter("button").charAt(0) == 's'){ 

			int noArticle = Integer.valueOf(request.getParameter("button").substring(1));

			try {
				manager.delete_art(noArticle);
				rd = request.getRequestDispatcher("index");
				rd.forward(request, response);

			} catch (Exception e) {

				e.printStackTrace();
				doGet(request, response);
			}
		}
		else if(request.getParameter("button").charAt(0) == 'c') {
			System.out.println("essai 1");
			int noArticle = Integer.valueOf(request.getParameter("button").substring(1));
			try {
				article = manager.getArticle(noArticle);
				System.out.println("essai 2");
			} catch (DALException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			article.setNomArticle(request.getParameter("nom"));
			article.setDescription(request.getParameter("descri"));
			article.setCategorie(Integer.valueOf(request.getParameter("categorie")));
			article.setPrixInitial(Integer.valueOf(request.getParameter("prix_initial")));
			article.setDateDebutEnchere(java.sql.Date.valueOf(request.getParameter("date_debut_enchere")));
			article.setDateFinEnchere(java.sql.Date.valueOf(request.getParameter("date_fin_enchere")));
			article.setRue(request.getParameter("rue"));
			article.setCode_postal(request.getParameter("code_postal"));
			article.setVille(request.getParameter("ville"));
			System.out.println("essai 3");

			try {

				manager.modifierArticle(article);
				request.setAttribute("no_article", article.getNoArticle());
				System.out.println("essai 4");
				rd = request.getRequestDispatcher("vente");
				rd.forward(request, response);
			} catch (DALException e) {
				message = "erreur lors de l'enregistrement de l'article veuillez contacter l'assistance";
				request.setAttribute("message", message);
				rd = request.getRequestDispatcher("WEB-INF/modifierArticle.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
		}
	}
}
