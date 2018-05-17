package metier;

public class Gateau {
	private int     id;
	private String  name;
	private Recette recette;
	
	public Gateau(String nomGateau, Recette rec) {
		this.name    = nomGateau;
		this.recette = rec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public Gateau(int id, String nomGat) {
		this.id = id;
		this.name = nomGat;
	}
	
	@Override
	public String toString() {
		return "Gateau [id=" + id + ", name=" + name + ", recette=" + recette + "]";
	}
}
