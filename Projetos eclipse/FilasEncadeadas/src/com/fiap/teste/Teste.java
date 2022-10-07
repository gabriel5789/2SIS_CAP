package com.fiap.teste;

import java.util.Scanner;

import com.fiap.fila.TipoFilaInt;

public class Teste {

	public static void main(String[] args) {
		TipoFilaInt fila = new TipoFilaInt();
		fila.init();
		
		Scanner input = new Scanner(System.in);
		int n=0;
		
		while(n!=-1) {n = input.nextInt(); fila.enqueue(n);}
		
		input.close();
		
		while(!fila.isEmpty()) {
			System.out.println(fila.dequeue());
		}

	}

}
