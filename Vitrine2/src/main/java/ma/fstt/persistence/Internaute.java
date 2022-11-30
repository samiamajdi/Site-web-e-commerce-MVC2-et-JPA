package ma.fstt.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Internaute")
public class Internaute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	@Column(length = 255, nullable = true)
	private String nom;
	@Column(length = 255, nullable = true)
	private String prenom;
	@Column(length = 255, nullable = true)
	private String email;
	@Column(length = 255, nullable = true)
	private String password;
	@OneToOne(mappedBy = "internaute")
    private Panier panier;
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public Internaute(Long id_user, String nom, String prenom, String email, String password) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		
	}
	public Internaute(Long id_user, String email, String password) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.password = password;
	}
	public Internaute() {
		super();
	}

}
