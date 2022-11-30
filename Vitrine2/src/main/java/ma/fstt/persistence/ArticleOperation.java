package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

public class ArticleOperation {
	private static final String PERSISTENCE_UNIT_NAME = "unit";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
public static void CommanderArticle(Long id,Integer qte,String currentUser) {
	System.out.println("id article");
	System.out.println(id);
	Query q=entityMgrObj.createQuery("SELECT p FROM Panier p WHERE p.internaute.id_user=?1",Panier.class);
	q.setParameter(1, Long.parseLong(currentUser));
	
	if(q.getResultList().size()>0) {
		transactionObj.begin();
		List<Panier> poo=q.getResultList();
		Panier pa=poo.get(0);
		Article o=entityMgrObj.find(Article.class,id);
		float pt=pa.getPrix_tot()+o.getPrix_article()*qte;
		pa.setPrix_tot(pt);
		entityMgrObj.merge(pa);
		
		
		
		
		PanierArticle pp=new PanierArticle(0L,qte,(Panier)q.getSingleResult(),o);
		entityMgrObj.persist(pp);
		transactionObj.commit();
	}else {
		Internaute i=entityMgrObj.find(Internaute.class,Long.parseLong(currentUser));
		Panier p=new Panier(0L,0,i);
		Article o=entityMgrObj.find(Article.class,id);
		p.setPrix_tot(o.getPrix_article()*qte);
		entityMgrObj.persist(p);
		
		PanierArticle pp=new PanierArticle(0L,qte,p,o);
		entityMgrObj.persist(pp);
	}
	
	
//	Query queryObj = entityMgrObj.createQuery("SELECT e FROM Article e WHERE e.id_article=?1",Article.class);
//	queryObj.setParameter(1, id);
	
//	Article a=(Article)queryObj.getSingleResult();
	transactionObj.begin();
	Article  a=entityMgrObj.find(Article.class, id);
	entityMgrObj.merge(a);
	System.out.println("name ???");
	System.out.println(a.getNom_article());
	Integer i=a.getQte_stock()-qte;
	a.setQte_stock(i);
	transactionObj.commit();
//	entityMgrObj.merge(a);
//	entityMgrObj.commit();
//	Query queryObjj =entityMgrObj.createQuery("UPDATE Article a SET  a.qte_stock=?1 where a.id_article=?2");
//	queryObjj.setParameter(1,i);
//	queryObjj.setParameter(2,id);
//	queryObjj.executeUpdate();
//	
	
	
}
}
