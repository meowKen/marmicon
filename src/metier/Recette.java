package metier;

import java.util.List;

public class Recette {
	private int idRec;
	private int idGat;
	private String tmpPrep;
	private List<Instruction> listInstr;
	private List<Ingredient> listIngre;
	
	
	public Recette(int idRec, int idGat, String tmpPrep) {
		this.idRec = idRec;
		this.idGat = idGat;
		this.tmpPrep = tmpPrep;
	}
	
	public Recette(String tmpPrep, List<Ingredient> listIngre, List<Instruction> listInstr) {
		this.idRec = idRec;
		this.idGat = idGat;
		this.tmpPrep = tmpPrep;
	}

	public String getTmpPrep() {
		return tmpPrep;
	}

	public void setTmpPrep(String tmpPrep) {
		this.tmpPrep = tmpPrep;
	}

	public List<Instruction> getListInstr() {
		return listInstr;
	}

	public void setListInstr(List<Instruction> listInstr) {
		this.listInstr = listInstr;
	}

	public List<Ingredient> getListIngre() {
		return listIngre;
	}

	public void setListIngre(List<Ingredient> listIngre) {
		this.listIngre = listIngre;
	}

	public int getIdRec() {
		return idRec;
	}

	public int getIdGat() {
		return idGat;
	}

	public String toString() {
		return "Recette [idRec=" + idRec + ", idGat=" + idGat + ", tmpPrep=" + tmpPrep + ", listInstr=" + listInstr
				+ ", listIngre=" + listIngre + "]";
	}
	
	
	
}
