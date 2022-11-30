package ma.fstt.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "PanierArticle")
public class PanierArticle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idPA;
	@Column(nullable = true)
	private int quantite;
@ManyToOne
@JoinColumn(name="pan_code") 
private Panier panier;
@ManyToOne
@JoinColumn(name="art_code") 
private Article article;
public Long getIdPA() {
	return idPA;
}
public void setIdPA(Long idPA) {
	this.idPA = idPA;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Panier getPanier() {
	return panier;
}
public void setPanier(Panier paniers) {
	this.panier = paniers;
}
public Article getArticle() {
	return article;
}
public void setArticle(Article articles) {
	this.article = articles;
}
public PanierArticle(Long idPA, int quantite, Panier paniers, Article articles) {
	super();
	this.idPA = idPA;
	this.quantite = quantite;
	this.panier = paniers;
	this.article = articles;
}
public PanierArticle() {
	super();
}

}
