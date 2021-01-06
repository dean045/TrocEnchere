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
import fr.eni.BO.Utilisateurs;
import fr.eni.DAL.DALException;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Manager manager = new Manager();
	RequestDispatcher rd = null;
	HttpSession session ;
	String resultat = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		rd = request.getRequestDispatcher("WEB-INF/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Utilisateurs user = new Utilisateurs();
			user = manager.connexion(request.getParameter("pseudo"), request.getParameter("mdp"));
			if(user != null)
			{
				session = request.getSession();
				session.setMaxInactiveInterval(10*60);
				session.setAttribute("user", user);
				rd = request.getRequestDispatcher("index");
				rd.forward(request, response);
			}
			else
			{
				resultat = "id ou mdp incorrect";
				request.setAttribute("resultat", resultat);
				doGet(request, response);
			}
		} catch (DALException e) {
			resultat = "echec de connexion";
			request.setAttribute("resultat", resultat);
			doGet(request, response);
		}
	}

}
