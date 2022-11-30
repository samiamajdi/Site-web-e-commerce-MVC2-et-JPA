package ma.fstt.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.persistence.Categorie;
import ma.fstt.persistence.CategorieOperation;
import ma.fstt.persistence.Internaute;
import ma.fstt.persistence.InternauteOperation;
import ma.fstt.persistence.Panier;

/**
 * Servlet implementation class ServletInternaute
 */
@WebServlet("/ServletInternaute")
public class ServletInternaute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInternaute() {
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
			case "inscription":
		
				page="inscription.jsp";
				break;
			case "connexion":
				
				page="connexion.jsp";
				break;
			case "deconnex": 
				session.invalidate();
				page="home.jsp"; 
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
		String action=request.getParameter("action");
		String pagee="";
		String message="";
		HttpSession session =request.getSession();
		System.out.println(action);
		switch(action) {
		case "inscriptiondone":
			String nom= request.getParameter("nom");
			String prenom= request.getParameter("prenom");
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			InternauteOperation.creerInternaute(nom,prenom, email, password);
			pagee="home.jsp";
			
			break; 
		case "ListeCategorie":
			
			String emailv= request.getParameter("email");
			String passwordv= request.getParameter("password");
			
			Internaute in = new Internaute();
			 in = InternauteOperation.verifierInteranute(emailv, passwordv);
			 if (in== null) {
				 message="adresse ou mot de passe incorrecte"; 
				 request.setAttribute("message", message);
				 pagee="connexion.jsp";  
				
			 }else {
				 message="";
				 String idses=Long.toString(in.getId_user());
				 String nomses= in.getNom();
					String prenomses= in.getPrenom();
					String emailses= in.getEmail();
					String passwordses= in.getPassword();
					session.setAttribute("iduser", idses);
					session.setAttribute("nom", nomses);
					session.setAttribute("prenom", prenomses);
					session.setAttribute("email", emailses);
					session.setAttribute("password", passwordses);
					
					List <Categorie> c=	CategorieOperation.getAllCategorie();
					System.out.println("SIZE :");
					System.out.println(c.size());
					request.setAttribute("listeC", c);
					
					pagee="vitrine.jsp"; 
			 }
			 
			
			
			break; 
			 
		}
		request.getRequestDispatcher(pagee).forward(request, response);
		
	
	}

}
