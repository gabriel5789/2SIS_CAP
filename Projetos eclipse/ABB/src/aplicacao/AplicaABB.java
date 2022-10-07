package aplicacao;

import java.util.Scanner;

import arvore.ABBint;

public class AplicaABB {

	public static void main(String[] args) {
		
		ABBint abb = new ABBint();
		Scanner le = new Scanner(System.in);
		int opcao, dado;
		
		do {
			System.out.println(" 0 - encerrar");
			System.out.println(" 1 - inserir");
			System.out.println(" 2 - lista em ordem");
			System.out.println(" 3 - contar");
			System.out.println(" 4 - consulta");
			System.out.println(" 5 - excluir");
			opcao = le.nextInt();
			
			switch (opcao) {
				case 0: 
					System.out.println("Encerrado");
					break;
				case 1: 
					System.out.println("Informe valor a ser inserido: ");
					dado = le.nextInt();
					abb.raiz = abb.inserir(abb.raiz, dado);
					break;
				case 2:
					System.out.println("Apresentação em ordem crescente");
					abb.listaEmOrdem(abb.raiz);
					break;
				case 3:
					System.out.println("A árvore tem " + abb.contaNos(abb.raiz) + " nós");
					break;
				case 4:
					System.out.print("Insira o dado a ser consultado: ");
					dado = le.nextInt();
					if(abb.consulta(abb.raiz, dado))
						System.out.println("O dado está no sistema");
					else
						System.out.println("O dado não está no sistema");
					
					break;
				case 5:
					System.out.print("Digite o valor a ser removido:");
					dado = le.nextInt();
					abb.remover(dado);
					break;
				default:
					System.out.println("Opção inválida");
			}
			
			
			} while  (opcao != 0);
		
		le.close();
	}
}
