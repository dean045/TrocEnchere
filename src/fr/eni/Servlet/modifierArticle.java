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
import fr.eni.DAL.DALException;

/**
 * Servlet implementation class modifierArticle
 */
@WebServlet("/modifierArticle")
public class modifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private HttpSession session;
	Manager manager = new Manager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rd = request.getRequestDispatcher("WEB-INF/modifierArticle.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		int noArticle = Integer.valueOf(request.getParameter("button").substring(1));
		
		
		if(request.getParameter("button").charAt(0) == 'm'){
			Articles article = new Articles();
			List<Categories> listeCat = new ArrayList<Categories>();
			
			try {
				article = manager.getArticle(noArticle);
				listeCat = manager.getLibelle();
				request.setAttribute("article", article);
				request.setAttribute("listeCat", listeCat);
			} catch (DALException e) {
			
				e.printStackTrace();
			}
			
			
			rd = request.getRequestDispatcher("WEB-INF/modifierArticle.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("button").charAt(0) == 's') {
			
		}
	}

}
