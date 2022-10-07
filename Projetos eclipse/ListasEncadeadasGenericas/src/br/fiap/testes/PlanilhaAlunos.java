package br.fiap.testes;

import java.util.Scanner;

public class PlanilhaAlunos {

	public static void main(String[] args) {
		int op;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("0 - Encerrar");
			System.out.println("1 - Insere aluno");
			System.out.println("2 - Remove aluno");
			System.out.println("3 - Consulta média do aluno");
			System.out.println("Opcao: ");
			op = input.nextInt();
			switch (op) {
			case 0:
				System.out.println("Encerrando o programa...");
				break;
			case 1:
				
				break;
			case 2:
				break;
			case 3: 
				break;
			default:
				break;
			}
		} while(op != 0);

	}

}
