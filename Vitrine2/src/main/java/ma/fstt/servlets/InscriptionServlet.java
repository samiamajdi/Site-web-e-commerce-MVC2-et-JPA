package ma.fstt.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.persistence.Article;
import ma.fstt.persistence.Categorie;
import ma.fstt.persistence.CategorieOperation;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="";
		Categorie uu= new Categorie();
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("ListeCategorie")) {
		
			List <Categorie> c=	CategorieOperation.getAllCategorie();
			System.out.println("SIZE :");
			System.out.println(c.size());
			request.setAttribute("listeC", c);
			page="vitrine.jsp";
		}
		if(action.equalsIgnoreCase("ConsulterC")) {
			System.out.println("id ctg"+request.getParameter("idc"));
			Long e=Long.parseLong(request.getParameter("idc"));
			List<Article> u=CategorieOperation.getArticleC(e);
			 System.out.println(u.size());

			for(int i=0;i<u.size();i++){
				
				 System.out.println("halaa"+u.get(i).getCategorie().getId_ctg());
				
			}
			
			request.setAttribute("listeA", u);
			page="listeA.jsp";
			
			
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
