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

/**
 * Servlet implementation class profil
 */
@WebServlet("/profil")
public class profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Manager manager = new Manager();
	RequestDispatcher rd = null;
	HttpSession session ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(null != request.getAttribute("profil"))
		{
			request.setAttribute("profil", request.getAttribute("profil"));
		}
		rd = request.getRequestDispatcher("WEB-INF/profil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		int no_utilisateur = ((Utilisateurs) session.getAttribute("user")).getNo_utilisateur();
		if(request.getParameter("button").equals("suppr")) {
			try {
				manager.removeUtilisateur(no_utilisateur);
				request.getSession().invalidate();
				rd = request.getRequestDispatcher("index");
				rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
				doGet(request, response);
			}
		}
		else if(request.getParameter("button").equals("modif")) {
			try {
				request.setAttribute("action", "afficher");
				rd = request.getRequestDispatcher("WEB-INF/modifier.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
				doGet(request, response);
			}
		}
		
	}

}
