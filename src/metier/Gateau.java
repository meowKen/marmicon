package metier;

public class Gateau {
	private int idGat;
	private int idRec;
	private String nomGat;
	private Recette recette;
	
	
	public Gateau(int idGat, int idRec, String nomGat) {
		this.idGat = idGat;
		this.idRec = idRec;
		this.nomGat = nomGat;
	}
	
	public Gateau(int idGat, int idRec, String nomGat, Recette recette) {
		this.idGat = idGat;
		this.idRec = idRec;
		this.nomGat = nomGat;
		this.recette = recette;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public int getIdGat() {
		return idGat;
	}

	public int getIdRec() {
		return idRec;
	}

	public String getNomGat() {
		return nomGat;
	}
	
	
	
	
	
}
