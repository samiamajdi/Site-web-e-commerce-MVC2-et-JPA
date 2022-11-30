package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PanierOperation {
	private static final String PERSISTENCE_UNIT_NAME = "unit";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	public static List consulterPanier(Long id) {
		System.out.println("ID ENTERED"+id);
		
		Query q=entityMgrObj.createQuery("SELECT p FROM Panier p WHERE p.internaute.id_user=?1",Panier.class);
		q.setParameter(1,id);
		List<Panier> pp=q.getResultList();
		Panier p=pp.get(0);
		System.out.println("id of panier "+p.getId_panier());
		Query qq=entityMgrObj.createQuery("SELECT pa FROM PanierArticle pa WHERE pa.panier.id_panier=?1",PanierArticle.class);
		qq.setParameter(1, p.getId_panier());
		List<PanierArticle> pa=qq.getResultList();
		
		return pa;
		
	}
	public static float prix_total(Long current) {
		Query q=entityMgrObj.createQuery("SELECT p FROM Panier p WHERE p.internaute.id_user=?1",Panier.class);
		q.setParameter(1,current);
		List<Panier> pp=q.getResultList();
		Panier p=pp.get(0);
		return p.getPrix_tot();
	}
	public static void deletePanier(Long id,Long ida) {
		Query q=entityMgrObj.createQuery("SELECT p FROM Panier p WHERE p.internaute.id_user=?1",Panier.class);
		q.setParameter(1,id);
		List<Panier> pp=q.getResultList();
		Panier p=pp.get(0);
		
		transactionObj.begin();
		PanierArticle l=entityMgrObj.find(PanierArticle.class,ida);
		Article o=entityMgrObj.find(Article.class,l.getArticle().getId_article());
		p.setPrix_tot(p.getPrix_tot()-l.getQuantite()*o.getPrix_article());
		entityMgrObj.merge(p);
		entityMgrObj.remove(l);
		transactionObj.commit();
	}
	

}
