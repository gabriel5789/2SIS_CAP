package com.fiap.fila;

public class TipoFilaInt {
	
	public static final int N = 16;
	int[] dados = new int[N];
	int fim;
	int inicio;
	int cont;
	
	public void init() {
		fim = inicio = cont = 0;
	}
	
	public void enqueue(int element) {
		if(this.isFull()) {
			System.out.println("FILA CHEIA!");
			return;
		}
		dados[fim] = element;
		cont++;
		fim = (fim+1) % N;
	}
	
	public int dequeue() {
		if(this.isEmpty()) return 0;
		int retorno = dados[inicio];
		inicio = (inicio+1) % N;
		cont--;
		return retorno;
	}
	
	public int first() {
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
