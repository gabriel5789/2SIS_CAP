package arvore;

public class ABBint {

	public class ARVORE {
		int dado;
		ARVORE esq, dir;
	}

	public ARVORE raiz = null;

	public ARVORE inserir(ARVORE p, int info) {
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info < p.dado)
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}

	public void listaEmOrdem(ARVORE p) {
		if (p != null) {
			listaEmOrdem(p.esq);
			System.out.println("Dado: " + p.dado);
			listaEmOrdem(p.dir);
		}
	}

	public int contaNos(ARVORE raiz) {
		return (raiz == null ? 0 : 1 + contaNos(raiz.dir) + contaNos(raiz.esq));
	}

	public boolean consulta(ARVORE raiz, int dado) {
		if (raiz == null)
			return false;
		return (raiz.dado == dado ? true : consulta(raiz.dir, dado) || consulta(raiz.esq, dado));
	}

	public int contaConsulta(ARVORE raiz, int dado) {
		if (raiz == null)
			return 0;
		return (raiz.dado == dado ? 1 : 1 + contaConsulta(raiz.esq, dado) + contaConsulta(raiz.dir, dado));
	}

	public void remover(int dado) {
		this.raiz = removeValor(this.raiz, dado);
	}

	private ARVORE removeValor(ARVORE node, int dado) {
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
				if (dado < node.dado)
					node.esq = removeValor(node.esq, dado);
				else
					node.dir = removeValor(node.dir, dado);
			}
		}
		return node;
	};

}
