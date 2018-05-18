package metier;

public class Gateau {
	private int idGat;
	private int idRec;
	private String nomGat;
	private Recette recette;
	private String Url;
	
	
	public Gateau(int idGat, int idRec, String nomGat) {
		this.idGat = idGat;
		this.idRec = idRec;
		this.nomGat = nomGat;
	}
	
	public Gateau(String nomGat, Recette rec, String url) {
		this.nomGat = nomGat;
		this.recette = rec;
		this.Url = url;
	}
	public Gateau(int idGat, String nomGat, String url) {
		this.idGat = idGat;
		this.nomGat = nomGat;
		this.Url = url;

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

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
	
	
	
	
}
