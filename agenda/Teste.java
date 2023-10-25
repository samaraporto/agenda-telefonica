package agenda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Agenda agenda=new Agenda();
				
		while(true) {
			int opcao=menu(input);
			if(opcao==1) {
				consultaContato(input, agenda);
			}else if(opcao==2) {
				adicionaContato(input, agenda);
			}else if(opcao==3) {
				System.out.println("Programa encerrado!");
				break;
			}
		}
		input.close();
	}
	public static void adicionaContato(Scanner input,Agenda agenda) {
		input.nextLine();
		if(agenda.getContatos().size()<5) {
			try {
				System.out.println("Digite as informações para criar um novo contato!");
				String nome=leInformacaoString(input, "Nome do contato: ");
				String telefone=leInformacaoString(input, "Telefone do contato: ");
				String email=leInformacaoString(input, "Email do contato: ");
				
				Contato contato=new Contato();
				contato.setNome(nome);
				contato.setTelefone(telefone);
				contato.setEmail(email);
				
				System.out.println(contato);
				agenda.adicionaAgenda(contato);
				} catch (AgendaCheiaException e) {
					System.out.println(e.getMessage());
				}
		}
	}
	public static void consultaContato(Scanner input,Agenda agenda) {
		input.nextLine();
		if(agenda.getContatos().size() > 0) {
			try {
				System.out.println("Digite o nome a ser consultado: ");
				String nome=input.nextLine();
				agenda.consultaAgenda(nome);
			} catch (ContatoNaoExisteException e) {
				System.out.println(e.getMessage());
			
				System.out.println("Contatos da agenda:");
				System.out.println(agenda);
			}
		}else System.out.println("Não há contatos na agenda!");
	}
	
	public static String leInformacaoString(Scanner input,String mensagem) {
		System.out.println(mensagem);
		String entrada=input.nextLine();
		return entrada;
	}
	
	public static int menu(Scanner input) {
        while (true) {
            System.out.println("===MENU===");
            System.out.println("Digite a opção: ");
            System.out.println("1 consulta");
            System.out.println("2 adiciona");
            System.out.println("3 sai");
            try {
                int opc = input.nextInt();
                if (opc == 1 || opc == 2 || opc == 3) {
                    return opc;
                } else {
                    throw new Exception("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
               input.nextLine(); // Limpar o buffer do scanner
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
