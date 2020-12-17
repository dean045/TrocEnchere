package fr.eni.Servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.BLL.Manager;
import fr.eni.BO.Articles;

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
		rd = request.getRequestDispatcher("WEB-INF/VendreArticle.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Articles item = new Articles(request.getParameter("nomArticle"), request.getParameter("description"), java.sql.Date.valueOf(request.getParameter("dateDebutEnchere")), 
									java.sql.Date.valueOf(request.getParameter("dateFinEnchere")), Integer.parseInt(request.getParameter("prixInitial")), 
									Integer.parseInt(request.getParameter("prixVente")), Integer.parseInt(request.getParameter("noUtilisateur")), "EC", 
									request.getParameter("img"), request.getParameter("categorie"), "erfze");

		try {
			manager.add_item(item);
			session = request.getSession();
			session.setAttribute("item", item);
			rd = request.getRequestDispatcher("index");
			rd.forward(request, response);
		} catch (DALException e) {
			message = "erreur lors de la création de la vente";
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("WEB-INF/VendreArticle.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
