package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("unit");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
//				Internaute internaute = new Internaute(0L,"Test","test","test","test",null);
//				List<Article> a=CategorieOperation.getArticleC(new Long(1));
//				System.out.println(a.get(0).getNom_article());
//				System.out.println(a.get(1).getNom_article());
				System.out.println("COMIITING");
//			    ArticleOperation.CommanderArticle(new Long(1),800);
//				em.persist(internaute);		
//				List <PanierArticle> o=PanierOperation.consulterPanier(Long.parseLong("1"));
				System.out.println("Quantite");
//				System.out.println(o.get(0).getQuantite());
				em.getTransaction().commit();

	

	}

}
