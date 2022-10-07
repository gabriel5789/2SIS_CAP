package exercicio5;

import java.util.Scanner;

import tipoPilha.TipoPilhaInt;

public class VerificaPalindromo {

	public static void main(String[] args) {
		TipoPilhaInt pilha = new TipoPilhaInt();
		int vetor[] = new int[TipoPilhaInt.N], 
			vetorReverso[] = new int[TipoPilhaInt.N];
		Scanner input = new Scanner(System.in);
		boolean palindromo = true; int n;
		
		for(int i=0; i<TipoPilhaInt.N && !pilha.isFull(); i++) {
			System.out.print("Digite o próximo número da sequência: ");
			n = input.nextInt();
			if (n < 0) break;
			vetor[i] = n;
			pilha.push(n);
		}
		
		for(int i=0; i<TipoPilhaInt.N && !pilha.isEmpty(); i++) {
			vetorReverso[i] = pilha.pop();
		}
		
		for (int i=0; i < vetor.length; i++) {
			if(vetor[i] != vetorReverso[i]) {
				palindromo=false;
				break;
			}
		}
		
		if (palindromo)
			System.out.println("A sequência informada é um palindromo");
		else
			System.out.println("A sequência informada não é um palindromo");
		
		input.close();

	}

}
