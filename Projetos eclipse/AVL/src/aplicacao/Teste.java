package aplicacao;

import java.util.Scanner;

import arvores.AVLInt;

public class Teste {
	public static void main(String[] args) {
		AVLInt avl = new AVLInt();
		Scanner le = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir");
			System.out.println("2 - Mostrar fator de balanceamento");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println("Finalizando o programa");
				break;
			case 1:
				System.out.print("Informe o valor a ser inserido: ");
				int info = le.nextInt();
				avl.raiz = avl.inserirH(avl.raiz, info);
				break;
			case 2:
				avl.mostraFB(avl.raiz);
				break;
			default:
				System.out.println("Opcao invalida!!!!!!1");
				break;
			}
		} while (opcao != 0);
		
	le.close();
	}
}
