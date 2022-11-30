package ma.fstt.persistence;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ctg;
	@Column(length = 255, nullable = true)
	private String nom_ctg;
	@OneToMany(mappedBy="Categorie",fetch=FetchType.LAZY)
	private Collection<Article> articles;
	public Long getId_ctg() {
		return id_ctg;
	}
	public void setId_ctg(Long id_ctg) {
		this.id_ctg = id_ctg;
	}
	public String getNom_ctg() {
		return nom_ctg;
	}
	public void setNom_ctg(String nom_ctg) {
		this.nom_ctg = nom_ctg;
	}
	public Collection<Article> getArticles() {
		return articles;
	}
	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	public Categorie(Long id_ctg, String nom_ctg, Collection<Article> articles) {
		super();
		this.id_ctg = id_ctg;
		this.nom_ctg = nom_ctg;
		this.articles = articles;
	}
	public Categorie() {
		super();
	}
	

}
