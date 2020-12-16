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
 * Servlet implementation class vente
 */
@WebServlet("/vente")
public class vente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Manager manager = new Manager();
	RequestDispatcher rd = null;
	HttpSession session ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noArticle = Integer.parseInt((String)request.getParameter("no_article").toString());
		Articles art = new Articles();
		try {
			art = manager.getArticle(noArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("art", art);
		rd = request.getRequestDispatcher("WEB-INF/detailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
