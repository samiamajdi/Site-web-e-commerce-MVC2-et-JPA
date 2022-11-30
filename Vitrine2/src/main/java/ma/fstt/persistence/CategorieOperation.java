package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CategorieOperation {

	private static final String PERSISTENCE_UNIT_NAME = "unit";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	@SuppressWarnings("unchecked")
	public static List getAllCategorie() {
		
		Query queryObj = entityMgrObj.createQuery("SELECT e FROM Categorie e");
		List<Categorie> lList = queryObj.getResultList();
		if (lList != null && lList.size() > 0) {			
			return lList;
		} else {
			return null;
		}
	}
	public static List getArticleC(Long idC) {
		System.out.println("HERE");
		System.out.println("given id :");
		System.out.println(idC);
		Query queryObj = entityMgrObj.createQuery("SELECT e FROM Article e WHERE e.categorie.id_ctg=?1",Article.class);
		queryObj.setParameter(1,idC);
		List<Categorie> lList = queryObj.getResultList();
		if (lList != null && lList.size() > 0) {			
			return lList;
		} else {
			return null;
		}
	}
}
