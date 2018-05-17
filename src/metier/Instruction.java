package metier;

public class Instruction {
	private int idInstr;
	private int idRec;
	private String instr;
	private int idOrdre;
	
	public Instruction(int idInstr, int idRec, String instr, int idOrdre) {
		this.idInstr = idInstr;
		this.idRec = idRec;
		this.instr = instr;
		this.idOrdre = idOrdre;
	}
	public Instruction( int idOrdre, String instr) {
		this.instr = instr;
		this.idOrdre = idOrdre;
	}

	public String getInstr() {
		return instr;
	}

	public void setInstr(String instr) {
		this.instr = instr;
	}

	public int getIdInstr() {
		return idInstr;
	}

	public int getIdRec() {
		return idRec;
	}

	public int getIdOrdre() {
		return idOrdre;
	}
	
}
