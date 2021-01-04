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
 * Servlet implementation class modifier
 */
@WebServlet("/modifier")
public class modifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Manager manager = new Manager();
	RequestDispatcher rd = null;
	String message;
	HttpSession session ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rd = request.getRequestDispatcher("WEB-INF/modifier");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		Utilisateurs user = (Utilisateurs) session.getAttribute("user");
		if(!request.getParameter("mot_de_passe").equals(request.getParameter("confirm")))
		{
			message = "Vous avez saisi 2 mots de passe différents. ";
		}
		else
		{
			try {
				if((manager.check(request.getParameter("pseudo")) || user.getPseudo().equals(request.getParameter("pseudo")))
						&& (manager.check(request.getParameter("email")) || user.getEmail().equalsIgnoreCase(request.getParameter("email"))))
				{
					user.setPseudo(request.getParameter("pseudo"));
					user.setNom(request.getParameter("nom"));
					user.setPrenom(request.getParameter("prenom"));
					user.setEmail(request.getParameter("email"));
					user.setTelephone(request.getParameter("telephone"));	
					user.setRue(request.getParameter("rue"));
					user.setCode_postal(request.getParameter("code_postal"));
					user.setVille(request.getParameter("ville"));
					user.setMot_de_passe(request.getParameter("mot_de_passe"));

					try {
						manager.modifierUtilisateur(user);
						session.setAttribute("user", user);
						rd = request.getRequestDispatcher("WEB-INF/profil.jsp");
						rd.forward(request, response);
					} catch (DALException e) {
						message = "erreur lors de l'inscription veuillez contacter l'assistance";
						request.setAttribute("message", message);
						rd = request.getRequestDispatcher("WEB-INF/modifier.jsp");
						rd.forward(request, response);
						e.printStackTrace();
					}
				}
				else
				{
					message = "votre mail ou pseudo est deja utilisé";
					request.setAttribute("message", message);
					rd = request.getRequestDispatcher("WEB-INF/modifier.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}


		}
		request.setAttribute("message", message);
		rd = request.getRequestDispatcher("WEB-INF/modifier.jsp");
		rd.forward(request, response);
	}

}
