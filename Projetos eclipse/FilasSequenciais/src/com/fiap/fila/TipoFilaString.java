package com.fiap.fila;

public class TipoFilaString {
	
	public static final int N = 16;
	String[] dados = new String[N];
	int fim;
	int inicio;
	int cont;
	
	public void init() {
		fim = inicio = cont = 0;
	}
	
	public void enqueue(String element) {
		if(this.isFull()) {
			System.out.println("FILA CHEIA!");
			return;
		}
		dados[fim] = element;
		cont++;
		fim = (fim+1) % N;
	}
	
	public String dequeue() {
		if(this.isEmpty()) return null;
		String retorno = dados[inicio];
		inicio = (inicio+1) % N;
		cont--;
		return retorno;
	}
	
	public String first() {
		return dados[inicio];
	}
	
	public boolean isEmpty() {
		if(cont==0)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if(cont==N)
			return true;
		return false;
	}
	
}
