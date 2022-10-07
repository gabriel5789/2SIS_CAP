package br.pan.usuario;

import br.pan.pilha.TipoPilhaMensagens;

public class Usuario {
	
	int id;
	String nome;
	String status;
	TipoPilhaMensagens pilhaMensagens;
	
	public Usuario(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = "ok";
		this.pilhaMensagens	= new TipoPilhaMensagens(16);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void enviaMsg(String msg) {
		this.pilhaMensagens.push(msg);
		this.status = "não ok";
	}

	public String leMsg() {
		String msg = this.pilhaMensagens.pop();
		
		if(this.pilhaMensagens.isEmpty())
			this.status = "ok";
		
		return msg;
		
	}
	
}
