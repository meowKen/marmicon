package metier;

import java.util.List;

public class Recette {
	private int               idGateau;
	private String            tempsPrep;
	private List<Ingredient>  listIng;
	private List<Instruction> listInt;
	
	public Recette(String tempsPrep, List<Ingredient> listIng, List<Instruction> listInt) {
		this.tempsPrep = tempsPrep;
		this.listIng   = listIng;
		this.listInt   = listInt;
	}

	public String getTempsPrep() {
		return tempsPrep;
	}

	public void setTempsPrep(String tempsPrep) {
		this.tempsPrep = tempsPrep;
	}

	public List<Ingredient> getListIng() {
		return listIng;
	}

	public void setListIng(List<Ingredient> listIng) {
		this.listIng = listIng;
	}

	public List<Instruction> getListInt() {
		return listInt;
	}

	public void setListInt(List<Instruction> listInt) {
		this.listInt = listInt;
	}

	@Override
	public String toString() {
		return "Recette [idGateau=" + idGateau + ", tempsPrep=" + tempsPrep + ", listIng=" + listIng + ", listInt="
				+ listInt + "]";
	}

}
