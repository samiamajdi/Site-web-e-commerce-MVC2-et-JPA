package ma.fstt.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.persistence.Article;
import ma.fstt.persistence.ArticleOperation;
import ma.fstt.persistence.CategorieOperation;
import ma.fstt.persistence.PanierArticle;
import ma.fstt.persistence.PanierOperation;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/PanierServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String page="";
		if(action.equalsIgnoreCase("commander")) {
			HttpSession session =request.getSession(false);
			String currentUser= (String) session.getAttribute("iduser");
			System.out.println("id_article :"+request.getParameter("id_article"));
			ArticleOperation.CommanderArticle(Long.parseLong(request.getParameter("id_article")), Integer.parseInt(request.getParameter("qte")),currentUser);
			Long e=Long.parseLong(request.getParameter("id_categorie"));
			List<Article> u=CategorieOperation.getArticleC(e);
			request.setAttribute("listeA", u);
			page="listeA.jsp";
			
		}
		if(action.equalsIgnoreCase("consulterPanier")) {
			HttpSession session =request.getSession(false);
			String currentUser= (String) session.getAttribute("iduser");
			List <PanierArticle> o=PanierOperation.consulterPanier(Long.parseLong(currentUser));
			PanierArticle e=o.get(0);
			System.out.println("test"+e.getQuantite());
			request.setAttribute("PanierArticle", o);
			request.setAttribute("prix_total",PanierOperation.prix_total(Long.parseLong(currentUser)));
			page="PanierArticle.jsp";
			
		}
		if(action.equalsIgnoreCase("deletePanier")) {
			HttpSession session =request.getSession(false);
			String currentUser= (String) session.getAttribute("iduser");
			PanierOperation.deletePanier(Long.parseLong(currentUser),Long.parseLong(request.getParameter("idpa")));
			List <PanierArticle> o=PanierOperation.consulterPanier(Long.parseLong(currentUser));
			PanierArticle e=o.get(0);
			System.out.println("test"+e.getQuantite());
			request.setAttribute("PanierArticle", o);
			request.setAttribute("prix_total",PanierOperation.prix_total(Long.parseLong(currentUser)));
			page="PanierArticle.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
