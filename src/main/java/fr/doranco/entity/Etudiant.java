package fr.doranco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private String specialite;
	@Column(nullable = true)
	private Integer age;

	public Etudiant() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Etudiant(String nom, String prenom, String specialite, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etudiant [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (nom != null) {
			builder.append("nom=");
			builder.append(nom);
			builder.append(", ");
		}
		if (prenom != null) {
			builder.append("prenom=");
			builder.append(prenom);
			builder.append(", ");
		}
		if (specialite != null) {
			builder.append("specialite=");
			builder.append(specialite);
			builder.append(", ");
		}
		if (age != null) {
			builder.append("age=");
			builder.append(age);
		}
		builder.append("]");
		return builder.toString();
	}

}
