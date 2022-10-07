package exercicio4;

import java.util.Scanner;

import tipoPilha.TipoPilhaInt;

public class DecimalParaBinario {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TipoPilhaInt pilha = new TipoPilhaInt();
		StringBuffer binario = new StringBuffer();
		int num, numInicial;
		
		do {
			System.out.print("Digite um n�mero: ");
			numInicial = num = input.nextInt();
			if(num > (Math.pow(2d, TipoPilhaInt.N) - 1))
				System.out.println("O n�mero m�ximo convers�vel � " + (int)
						(Math.pow(2d, TipoPilhaInt.N) - 1));
		} while (num > (Math.pow(2d, TipoPilhaInt.N) - 1));
		
		while(num > 0) {
			pilha.push(num % 2);
			num /= 2;
		}
		
		while(!pilha.isEmpty())
			binario.append(pilha.pop());
		
		System.out.println(numInicial + " em bin�rio: " + binario.toString());
		
		input.close();
	}
	

}
