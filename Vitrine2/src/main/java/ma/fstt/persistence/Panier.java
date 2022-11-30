package ma.fstt.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Panier")
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_panier;
	@Column(nullable = true)
	private float prix_tot;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private Internaute internaute;
	public Long getId_panier() {
		return id_panier;
	}
	public void setId_panier(Long id_panier) {
		this.id_panier = id_panier;
	}
	public float getPrix_tot() {
		return prix_tot;
	}
	public void setPrix_tot(float prix_tot) {
		this.prix_tot = prix_tot;
	}
//	public List<Article> getPosts() {
//		return posts;
//	}
//	public void setPosts(List<Article> posts) {
//		this.posts = posts;
//	}
	public Internaute getInternaute() {
		return internaute;
	}
	public void setInternaute(Internaute internaute) {
		this.internaute = internaute;
	}
	public Panier(Long id_panier, float prix_tot, Internaute internaute) {
		super();
		this.id_panier = id_panier;
		this.prix_tot = prix_tot;
//		this.posts = posts;
		this.internaute = internaute;
	}
	public Panier() {
		super();
	}
	@OneToMany(mappedBy="Panier",fetch=FetchType.LAZY)
	private Collection<PanierArticle> panierarticle;
	
}
