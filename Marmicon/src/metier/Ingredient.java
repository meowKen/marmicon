package metier;

public class Ingredient {
	
	private int    id;
	private String qte;
	private String nom;
	
	public Ingredient(String nom, String qte) {
		this.nom = nom;
		this.qte = qte;
	}
	public String getQte() {
		return qte;
	}
	public void setQte(String qte) {
		this.qte = qte;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
