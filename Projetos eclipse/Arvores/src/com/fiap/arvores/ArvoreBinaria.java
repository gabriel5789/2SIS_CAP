package com.fiap.arvores;

public class ArvoreBinaria {
	
	Node root;
	
	public class Node {
		Node esq, dir;
		int dado;
	}
	
	public void preOrdem(Node node) {
		if(node != null) {
			System.out.println(node.dado);
			if(node.esq != null) {
				preOrdem(node.esq);
			}
			if(node.dir != null) {
				preOrdem(node.dir);
			}
		}
	}
	
	public void inOrdem(Node node) {
		if(node != null) {
			if(node.esq != null) {
				inOrdem(node.esq);
			}
			System.out.println(node.dado);
			if(node.dir != null) {
				inOrdem(node.dir);
			}
		}
	}
	
	public void posOrdem(Node node) {
		if(node != null) {
			if(node.esq != null) {
				posOrdem(node.esq);
			}
			if(node.dir != null) {
				posOrdem(node.dir);
			}
			System.out.println(node.dado);
		}
	}
	
	public Node inserir( int dado) {
		return null;
	};
	
}
