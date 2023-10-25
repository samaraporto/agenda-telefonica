package agenda;

public class Contato {
	private static int contador=1;
	
	private String nome;
	private String telefone;
	private String email;
	private int id;
	
	public Contato() {
		id=contador++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		String s="[";
		s+= "id: "+id;
		s+= ", nome: "+nome;
		s+= ", telefone; "+telefone;
		s+= ", email: "+email+"]";
		return s;
	}
	
	
}
