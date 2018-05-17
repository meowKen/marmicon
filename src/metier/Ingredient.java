package metier;

public class Ingredient {
	private int idIng;
	private String nomIng;
	private String qteIng;
	private int idRec;
	
	public Ingredient(int idIng, String nomIng, String qteIng, int idRec) {
		this.idIng = idIng;
		this.nomIng = nomIng;
		this.qteIng = qteIng;
		this.idRec = idRec;
	}
	
	public Ingredient(String nomIng, String qteIng) {
		this.nomIng = nomIng;
		this.qteIng = qteIng;
	}

	public int getIdIng() {
		return idIng;
	}

	public String getNomIng() {
		return nomIng;
	}

	public String getQteIng() {
		return qteIng;
	}

	public int getIdRec() {
		return idRec;
	}

	@Override
	public String toString() {
		return "Ingredient [nomIng=" + nomIng + ", qteIng=" + qteIng + "]";
	}
	
	
	
	
	
}
