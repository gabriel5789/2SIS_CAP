package arvores;

import cliente.Cliente;

public class AVLCliente {
	private class ARVORE {
		Cliente dado; /* Método equals foi sobrescrito na classe Cliente */
		ARVORE esq, dir;
		int hEsq, hDir;
	}

	private ARVORE raiz = null;
	
	public void inserir(Cliente info) {
		this.raiz = inserirAVL(raiz, info);
	}

	private ARVORE inserirAVL(ARVORE p, Cliente info) {
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
			p.hDir=0;
			p.hEsq=0;
		} else if (info.getNumero() < p.dado.getNumero()) {
			p.esq = inserirAVL(p.esq, info);
			if(p.esq.hDir > p.esq.hEsq)
				p.hEsq = p.esq.hDir + 1;
			else
				p.hEsq = p.esq.hEsq + 1;
			p = balanceamento(p);
		} else {
			p.dir = inserirAVL(p.dir, info);
			if(p.dir.hDir > p.dir.hEsq)
				p.hDir = p.dir.hDir + 1;
			else
				p.hDir = p.dir.hEsq + 1;
			p = balanceamento(p);
		}
		atualizaAlturas(raiz);
		return p;
	}
	
	private ARVORE balanceamento(ARVORE p) {
		int FB = p.hDir - p.hEsq;
		if (FB > 1) {
			int fbFilhoDir = p.dir.hDir - p.dir.hEsq;
			if (fbFilhoDir >= 0)
				p = rotacaoEsquerda(p);
			else {
				p.dir = rotacaoDireita(p.dir);
				p = rotacaoEsquerda(p);
			}
		} else {
			if(FB < -1) {
				int fbFilhoEsq = p.esq.hDir - p.esq.hEsq;
				if(fbFilhoEsq <= 0)
					p = rotacaoDireita(p);
				else {
					p.esq = rotacaoEsquerda(p.esq);
					p = rotacaoDireita(p);
				}
			}
		}
		return p;
	}
	
	private void atualizaAlturas(ARVORE p) {
		if(p != null) {
			atualizaAlturas(p.esq);
			if(p.esq == null)
				p.hEsq = 0;
			else if(p.esq.hEsq > p.esq.hDir)
				p.hEsq = p.esq.hEsq + 1;
			else
				p.hEsq = p.esq.hDir + 1;
			atualizaAlturas(p.dir);
			if(p.dir == null)
				p.hDir = 0;
			else if(p.dir.hEsq > p.dir.hDir)
				p.hDir = p.dir.hEsq + 1;
			else
				p.hDir = p.dir.hDir + 1;
		}
	}
	
	private ARVORE rotacaoDireita(ARVORE p) {
		ARVORE q, temp;
		q = p.esq;
		temp = q.dir;
		q.dir = p;
		p.esq = temp;
		return q;
	}
	
	private ARVORE rotacaoEsquerda(ARVORE p) {
		ARVORE q, temp;
		q = p.dir;
		temp = q.esq;
		q.esq = p;
		p.dir = temp;
		return q;
	}

	public void listaEmOrdem() {
		listaEmOrdem(this.raiz);
	}
	
	private void listaEmOrdem(ARVORE p) {
		if (p != null) {
			listaEmOrdem(p.esq);
			System.out.println("Dado: " + p.dado + " | FB: " + (p.hDir - p.hEsq));
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
		return (dado.getNumero() > raiz.dado.getNumero() ? 
				1 + contaConsulta(raiz.dir, dado) : 
				1 + contaConsulta(raiz.esq, dado));
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
