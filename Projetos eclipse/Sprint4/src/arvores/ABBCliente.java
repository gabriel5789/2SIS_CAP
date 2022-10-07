package arvores;

import cliente.Cliente;

public class ABBCliente {

	private class ARVORE {
		Cliente dado; /* Método equals foi sobrescrito na classe Cliente */
		ARVORE esq, dir;
	}

	private ARVORE raiz = null;
	
	public void inserir(Cliente info) {
		this.raiz = inserir(raiz, info);
	}

	private ARVORE inserir(ARVORE p, Cliente info) {
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info.getNumero() < p.dado.getNumero())
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}

	public void listaEmOrdem() {
		listaEmOrdem(this.raiz);
	}
	
	private void listaEmOrdem(ARVORE p) {
		if (p != null) {
			listaEmOrdem(p.esq);
			System.out.println("Dado: " + p.dado);
			listaEmOrdem(p.dir);
		}
	}
	
	public int contaNos() {
		return contaNos(this.raiz);
	}

	private int contaNos(ARVORE raiz) {
		return (raiz == null ? 0 : 1 + contaNos(raiz.dir) + contaNos(raiz.esq));
	}

	public boolean consulta(Cliente dado) {
		return consulta(this.raiz, dado);
	}

	private boolean consulta(ARVORE raiz, Cliente dado) {
		if (raiz == null)
			return false;
		if(raiz.dado == dado) return true;
		return (dado.getNumero() > raiz.dado.getNumero() ? consulta(raiz.dir, dado) : consulta(raiz.esq, dado));
	}
	
	public int contaConsulta(Cliente dado) {
		return contaConsulta(this.raiz, dado);
	}

	private int contaConsulta(ARVORE raiz, Cliente dado) {
		if (raiz == null)
			return 0;
		if(raiz.dado == dado) return 1;
		return (dado.getNumero() > raiz.dado.getNumero() ? 1 + contaConsulta(raiz.dir, dado) : 1 + contaConsulta(raiz.esq, dado));
	}

	public void remover(Cliente dado) {
		this.raiz = removeValor(this.raiz, dado);
	}

	private ARVORE removeValor(ARVORE node, Cliente dado) {
		if (node != null) {
			if (dado == node.dado) {
				if (node.esq == null && node.dir == null)
					return null;
				else {
					if (node.esq == null)
						return node.dir;
					if (node.dir == null)
						return node.esq;
					ARVORE aux = node.dir, ref = node.dir;
					while (aux.esq != null)
						aux = aux.esq;
					aux.esq = node.esq;
					return ref;
				}
			} else {
				if (dado.getNumero() < node.dado.getNumero())
					node.esq = removeValor(node.esq, dado);
				else
					node.dir = removeValor(node.dir, dado);
			}
		}
		return node;
	};
	
	public Cliente maximo() {
		ARVORE aux = raiz;
		while (aux.dir != null)
			aux = aux.dir;
		return aux.dado;
	}
	
	public Cliente minimo() {
		ARVORE aux = raiz;
		while (aux.esq != null)
			aux = aux.esq;
		return aux.dado;
	}

}
