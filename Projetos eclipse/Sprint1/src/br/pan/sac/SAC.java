package br.pan.sac;

import java.util.Scanner;

import br.pan.usuario.Usuario;

public class SAC {
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		System.out.print("Digite nome do cliente: ");
		
		String nome = le.nextLine();
		System.out.print("Digite id do cliente: ");
		int id = le.nextInt();
		Usuario cliente = new Usuario(id, nome);
		int opcao;
		do {
			System.out.println(" \n 0- para sair do sistema ");
			System.out.println(" 1- para enviar mensagem de feedback");
			System.out.println(" 2- ler e responder mensagem de feedback ");
			System.out.print("Digite op��o: ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println("Finalizado o atendimento");
				break;
			case 1:
				System.out.println("Digite mensagem a ser enviada: ");
				le.nextLine();
				String msg = le.nextLine();
				cliente.enviaMsg(msg);
				break;
			case 2:
				if (cliente.getStatus() == "n�o ok")
					System.out.println(cliente.leMsg());
				else
					System.out.println("N�o h� mensagens a serem respondidas");
				break;
			default:
				System.out.println("Op��o inv�lida!");
			}
		} while (opcao != 0);
		
		le.close();
	}
}