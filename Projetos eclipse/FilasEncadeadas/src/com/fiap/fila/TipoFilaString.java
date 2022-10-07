package com.fiap.fila;

import com.fiap.lista.NodeString;

public class TipoFilaString {
	
	NodeString inicio;
	NodeString fim;
	
	public void init() {
		inicio = fim = null;
	}
	
	public boolean isEmpty() {
		if(inicio==null && fim == null) {
			return true;
		}
		return false;
	}
	
	public void enqueue(String valor) {
		NodeString node = new NodeString();
		node.dado = valor;
		node.prox = null;
		if(this.isEmpty())
			this.inicio = node;
		else
			fim.prox = node;
		fim = node;
	}
	
	public String dequeue() {
		String retorno = inicio.dado;
		
		inicio = inicio.prox;
		if(inicio == null) fim = null;
		
		return retorno;
	}
	
	public String first() {
		return inicio.dado;
	}
	
}
