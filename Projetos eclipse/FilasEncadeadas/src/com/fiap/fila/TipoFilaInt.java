package com.fiap.fila;

import com.fiap.lista.NodeInt;

public class TipoFilaInt {
	
	NodeInt inicio;
	NodeInt fim;
	
	public void init() {
		inicio = fim = null;
	}
	
	public boolean isEmpty() {
		if(inicio==null && fim == null) {
			return true;
		}
		return false;
	}
	
	public void enqueue(int valor) {
		NodeInt node = new NodeInt();
		node.dado = valor;
		node.prox = null;
		if(this.isEmpty())
			this.inicio = node;
		else
			fim.prox = node;
		fim = node;
	}
	
	public int dequeue() {
		int retorno = inicio.dado;
		
		inicio = inicio.prox;
		if(inicio == null) fim = null;
		
		return retorno;
	}
	
	public int first() {
		return inicio.dado;
	}
	
}
