package fr.eni.Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.BLL.Manager;
import fr.eni.BO.Articles;
import fr.eni.BO.Utilisateurs;
import fr.eni.DAL.DALException;

/**
 * Servlet implementation class creation_article
 */
@WebServlet("/creation_article")
public class creation_article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	HttpSession session ;
	Manager manager = new Manager();
	String message ;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		if (null == session.getAttribute("user")) {
			request.setAttribute("resultat", "Vous devez vous connecter pour pouvoir vendre un article");
			rd = request.getRequestDispatcher("WEB-INF/login.jsp");
			rd.forward(request, response);
		}
		else {
			rd = request.getRequestDispatcher("WEB-INF/VendreArticle.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		Date date_debut =  java.sql.Date.valueOf(request.getParameter("date_debut"));
		Date date_fin =  java.sql.Date.valueOf(request.getParameter("date_fin"));
		Utilisateurs user = (Utilisateurs) session.getAttribute("user");
		Articles item = new Articles(request.getParameter("nom"), request.getParameter("descri"),date_debut,date_fin,
				Integer.valueOf(request.getParameter("prix")),user.getNo_utilisateur(),"EC","img",request.getParameter("categorie"),request.getParameter("rue"),request.getParameter("codepostal"),request.getParameter("ville"));
		try {
			manager.add_item(item);
			session.setAttribute("item", item);
			item = manager.getArticle(item.getNoArticle());
			request.setAttribute("art", item);
			rd = request.getRequestDispatcher("WEB-INF/detailVente.jsp");
			rd.forward(request, response);
		} catch (DALException e) {
			message = "erreur lors de la création de la vente";
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("WEB-INF/VendreArticle.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
		
	}

}
