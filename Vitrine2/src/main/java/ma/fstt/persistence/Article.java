package ma.fstt.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_article;
	@Column(length = 255, nullable = true)
	private String nom_article;
	@Column(nullable = true)
	private float prix_article;
	@Column(nullable = true)
	private int Qte_stock;
	@Column(length = 255, nullable = true)
    private String imageFileName;
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public int getQte_stock() {
		return Qte_stock;
	}
	public void setQte_stock(int qte_stock) {
		Qte_stock = qte_stock;
	}
	public Collection<PanierArticle> getPanierarticle() {
		return panierarticle;
	}
	public void setPanierarticle(Collection<PanierArticle> panierarticle) {
		this.panierarticle = panierarticle;
	}
	@ManyToOne
	@JoinColumn(name="ctg_code") 
	private Categorie categorie;
	@OneToMany(mappedBy="Article",fetch=FetchType.LAZY)
	private Collection<PanierArticle> panierarticle;
	
	public Article() {
		super();
	}
	public Long getId_article() {
		return id_article;
	}
	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public float getPrix_article() {
		return prix_article;
	}
	public void setPrix_article(float prix_article) {
		this.prix_article = prix_article;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
//	public List<Panier> getPaniers() {
//		return paniers;
//	}
//	public void setPaniers(List<Panier> paniers) {
//		this.paniers = paniers;
//	}
	public Article(Long id_article, String nom_article, float prix_article, Categorie categorie, List<Panier> paniers) {
		super();
		this.id_article = id_article;
		this.nom_article = nom_article;
		this.prix_article = prix_article;
		this.categorie = categorie;
//		this.paniers = paniers;
	}
	
	

}
