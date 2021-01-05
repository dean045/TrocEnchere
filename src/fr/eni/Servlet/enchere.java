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
import fr.eni.BO.Utilisateurs;
import fr.eni.DAL.DALException;

/**
 * Servlet implementation class enchere
 */
@WebServlet("/enchere")
public class enchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher rd;
	Manager manager = new Manager();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		if (null == session.getAttribute("user")) {
			request.setAttribute("resultat", "Vous devez vous connecter pour enchérir sur un article");
			rd = request.getRequestDispatcher("WEB-INF/login.jsp");
			rd.forward(request, response);
		}
		else {
			Utilisateurs user = (Utilisateurs) session.getAttribute("user");
			if(user.getCredit() >= Integer.valueOf(request.getParameter("enchere"))) {

				try {
					Articles art = manager.getArticle(Integer.valueOf(request.getParameter("noArticle")));
					if(art.getNo_acheteur() != 0) {
						Utilisateurs utilisateur = new Utilisateurs();
						utilisateur = manager.getUser(art.getNo_acheteur());
						utilisateur.setCredit(utilisateur.getCredit() + art.getPrixVente());						
					}
					
					art.setNo_acheteur(user.getNo_utilisateur());
					user.setCredit(user.getCredit() - Integer.valueOf(request.getParameter("propoEnchere")));
					manager.modifierUtilisateur(user);
					
				} catch (NumberFormatException e) {					
					e.printStackTrace();
				} catch (DALException e) {
					e.printStackTrace();
				}

			}
			rd = request.getRequestDispatcher("WEB-INF/detailVente.jsp");
			rd.forward(request, response);
		}
	}

}
