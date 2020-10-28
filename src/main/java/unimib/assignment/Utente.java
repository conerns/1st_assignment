package unimib.assignment;

public class Utente {
	private int idUtente;
	private String nomeUtente;
	private int numeroAccessi;
	
	
	public Utente(int id, String nomeU, int numeroAcc) {
		this.idUtente = id;
		this.nomeUtente = nomeU;
		this.numeroAccessi = numeroAcc;
	}
	
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public int getNumeroAccessi() {
		return numeroAccessi;
	}

	public void setNumeroAccessi(int numeroAccessi) {
		this.numeroAccessi = numeroAccessi;
	}
	
}
