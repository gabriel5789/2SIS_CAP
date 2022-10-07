package com.fiap.teste;

import com.fiap.lista.NodeInt;

public class ExemploLista {

	public static void main(String[] args) {
		NodeInt novo2 = new NodeInt();
		novo2.dado = 1;
		novo2.prox = null;
		
		NodeInt lista = new NodeInt();
		lista.dado = 2;
		lista.prox = null;
		novo2.prox = lista;
		
		NodeInt novo = new NodeInt();
		novo.dado=3;
		lista.prox = novo;
		novo.prox=null;
		
		NodeInt aux=novo2; int i=1;
		while(aux != null) {
			System.out.print(i++ + "º nó - ");
			System.out.print("Dado: " + aux.dado);
			System.out.println("\tthis: " + aux + "\tProx: " + aux.prox);
			aux = aux.prox;
		}
		
	}

}
