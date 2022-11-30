package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InternauteOperation {

	private static final String PERSISTENCE_UNIT_NAME = "unit";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	
	
	
	// Method To Add Create School Details In The Database
		public static void creerInternaute(String nom,String prenom,String email,String password) {
			if(!transactionObj.isActive()) {
				transactionObj.begin();
			}

			Internaute internaute = new Internaute(0L, nom , prenom,email,password);
			Query queryObj = entityMgrObj.createQuery("SELECT c FROM Internaute AS c WHERE c.email = ?1",Internaute.class).setParameter(1, email);
			
			entityMgrObj.persist(internaute);
			transactionObj.commit();
				
		}
		public static Internaute verifierInteranute(String email,String password) {
			if(!transactionObj.isActive()) {
				transactionObj.begin();
			}
        
			
			Query queryObj = entityMgrObj.createQuery("SELECT c FROM Internaute AS c WHERE c.email = ?1 and c.password=?2",Internaute.class).setParameter(1, email).setParameter(2, password);
			Internaute internaute = (Internaute) queryObj.getResultList().stream().findFirst().orElse(null);
			//Query queryO = entityMgrObj.createQuery("SELECT e FROM Panier AS c WHERE c.email = ?1 and c.password=?2",Internaute.class).setParameter(1, email).setParameter(2, password);
			transactionObj.commit();
			
			return internaute;
				
		
        }
		/*public static Panier chercherPanier(Long id) {
			if(!transactionObj.isActive()) {
				transactionObj.begin();
			}
        
			
			Query queryObj = entityMgrObj.createQuery("SELECT p FROM Panier AS p WHERE p.User_d = ?1 ",Panier.class).setParameter(1, id);
			Panier panier = (Panier) queryObj.getResultList().stream().findFirst().orElse(null);
			//Query queryO = entityMgrObj.createQuery("SELECT e FROM Panier AS c WHERE c.email = ?1 and c.password=?2",Internaute.class).setParameter(1, email).setParameter(2, password);
			transactionObj.commit();
			
			return panier;
				
		
        }
		*/
		
	
	
	

	


}
