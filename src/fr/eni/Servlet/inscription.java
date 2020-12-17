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
 * Servlet implementation class inscription
 */
@WebServlet("/inscription")
public class inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Manager manager = new Manager();
	String message ;
	RequestDispatcher rd = null;
	HttpSession session ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rd = request.getRequestDispatcher("WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameter("mot_de_passe").equals(request.getParameter("confirm")))
		{
			message = message + "Vous avez saisi 2 mots de passe différents. ";
		}
		else
		{
			Utilisateurs user = new Utilisateurs(request.getParameter("pseudo"),request.getParameter("nom"), 
					request.getParameter("prenom"),request.getParameter("email"),request.getParameter("telephone"), 
					request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"),
					request.getParameter("mot_de_passe"), 0, 0);
			
			try {
				manager.add_user(user);
				session = request.getSession();
				session.setAttribute("user", user);
				rd = request.getRequestDispatcher("index");
				rd.forward(request, response);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		rd = request.getRequestDispatcher("WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

}
