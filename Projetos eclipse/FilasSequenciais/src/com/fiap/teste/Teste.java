package com.fiap.teste;

import com.fiap.fila.TipoFilaInt;

public class Teste {

	public static void main(String[] args) {
		TipoFilaInt a = new TipoFilaInt();
		a.init();
		
		
		for(int i=0; i<20; i++) {
			a.enqueue(i);
		}
		
		while(!a.isEmpty()) {
			System.out.print(a.dequeue() + " ");
		}
		
	}

}
