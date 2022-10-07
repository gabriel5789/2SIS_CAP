package br.fiap.fila;

import br.fiap.cliente.Cliente;

public class Mensagem {
	
	private Cliente cliente;
	private String mensagem;
	
	public Mensagem(Cliente cliente, String msg) {
		this.cliente = cliente;
		this.mensagem = msg;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
