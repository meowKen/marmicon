package metier;

public class Instruction {
	private int    id;
	private int    ordre;
	private String indication;
	
	public Instruction(int ordre, String indic) {
		this.ordre      = ordre;
		this.indication = indic;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

}
