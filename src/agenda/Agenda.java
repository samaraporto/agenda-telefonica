package agenda;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contato> contatos;
	
	public Agenda() {
		contatos=new ArrayList<>();
	}
	
	public void adicionaAgenda(Contato c) throws AgendaCheiaException {
		if (contatos.size()<5) {
			contatos.add(c);
			System.out.println("Contato adicionado!");
		}else {
			throw new AgendaCheiaException();
		}
	}
	
	public void consultaAgenda(String nome) throws ContatoNaoExisteException {
		boolean existe=false;
		if (contatos.size()>0) {
			for (Contato contato : contatos) {
				if (contato.getNome().equalsIgnoreCase(nome)) {
					System.out.println(nome+" consta na agenda: ");
					System.out.println(contato);
					existe=true;
					break;
				}
			}if(!existe)throw new ContatoNaoExisteException(nome);
		}else System.out.println("A agenda está vazia!");
	}
	
	public ArrayList<Contato> getContatos() {
		return contatos;
	}

	@Override
	public String toString() {
		String s="";
		for (Contato c:contatos) {
			s=c.toString()+"\n";
		}
		return s;
	}
	
}
