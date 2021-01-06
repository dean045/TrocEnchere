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
import fr.eni.BO.Utilisateurs;
import fr.eni.DAL.DALException;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	HttpSession session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager manager =  new Manager();

		List<Articles> liste = new ArrayList<Articles>();
		List<Categories> listeCat = new ArrayList<Categories>();
		int no_cat = 0;
		try {
			manager.refresh_art();
			listeCat = manager.getLibelle();
			if(null != request.getParameter("nom_select"))
			{
				no_cat = Integer.valueOf(request.getParameter("nom_select"));
			}
			try {
				liste = manager.getliste(no_cat);
			} 
			catch (DALException e) {
				e.printStackTrace();
			}
		} catch (DALException e1) {
			e1.printStackTrace();
		}


		request.setAttribute("listeCat", listeCat);

		request.setAttribute("liste", liste);
		rd = request.getRequestDispatcher("WEB-INF/Accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = null;
		temp = request.getParameter("log");
		if(null != temp) request.getSession().invalidate();
		doGet(request, response);
	}
}
