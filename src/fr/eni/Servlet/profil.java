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

		rd = request.getRequestDispatcher("WEB-INF/profil.jsp" );
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		if(null != request.getParameter("profil"))
		{
			int no_utilisateur = Integer.valueOf(request.getParameter("profil"));
			try {
				Utilisateurs user1 = manager.getUser(no_utilisateur);
				request.setAttribute("profil", user1);
				rd = request.getRequestDispatcher("WEB-INF/profil.jsp");
				rd.forward(request, response);
			} catch (DALException e) {
				e.printStackTrace();
			}

		}
		else {
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

}
