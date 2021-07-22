package classi;

public class Persona {

	private final int ID;
	private String nome;
	private String cognome;
	private String mail;

	public Persona(int id,String...strings ) {
		this.ID = id;
		this.nome = strings[0];
		this.cognome = strings[1];
		this.mail = strings[2];
	}
	
	public void modifica(String...strings ) {
		this.nome = strings[0];
		this.cognome = strings[1];
		this.mail = strings[2];
	}
	
	@Override
	public String toString() {
		return "Persona [ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getID() {
		return ID;
	}
}
