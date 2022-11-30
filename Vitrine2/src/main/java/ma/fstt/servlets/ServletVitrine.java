package ma.fstt.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletVitrine
 */
@WebServlet("/ServletVitrine")
public class ServletVitrine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVitrine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="";
		HttpSession session =request.getSession(false);
		boolean y=false;
		Enumeration a=request.getParameterNames();
		boolean o=false;
		 while(a.hasMoreElements()){
			 
				if(a.nextElement().equals("action"))
				{
					
					o=true; 
				System.out.println("Changed");
				}
		
			}
		
		
		 if (o) {
			 
		System.out.println("je suis la");
		String action=request.getParameter("action");
		System.out.println("Param : ");
		System.out.println(action);
		try {
	
			switch(action) {
			case "categorie":
				String idses= (String) session.getAttribute("iduser");
				System.out.println(idses);
				page="categorie.jsp";
				break;
		
		
	}
	
	
			request.getRequestDispatcher(page).forward(request, response);
		}catch(Exception ex){}
		 }
		 else {
			 System.out.println("no action specified");
			 request.getRequestDispatcher("home.jsp").forward(request, response);
			 
		}
		
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
