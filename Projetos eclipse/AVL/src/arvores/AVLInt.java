package arvores;

public class AVLInt {

	private class ARVORE {
		int dado;
		ARVORE dir, esq;
		int hDir, hEsq;
	}

	public ARVORE raiz = null;

	public ARVORE inserirH(ARVORE p, int info) {
		if (p == null) { // nó inserido sempre será nó folha
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
			p.hDir = 0;
			p.hEsq = 0;
		} else if (p.dado > info) {
			p.esq = inserirH(p.esq, info);
			if (p.esq.hDir > p.esq.hEsq) // Altura do nó será a maior
				p.hEsq = p.esq.hDir + 1; // altura dos seus filhos
			else
				p.hEsq = p.esq.hEsq + 1;
		} else {
			p.dir = inserirH(p.dir, info);
			if (p.dir.hDir > p.dir.hEsq)
				p.hDir = p.dir.hDir + 1;
			else
				p.hDir = p.dir.hEsq + 1;
		}
		return p;
	}
	
	public void mostraFB(ARVORE node) {
		if (node != null) {
			System.out.println("No " + node.dado + ": " + (node.hDir - node.hEsq));
			mostraFB(node.esq);
			mostraFB(node.dir);
		}
	}
	
	public ARVORE rotacaoDireita(ARVORE p) {
		ARVORE q, temp;
		q = p.esq;
		temp = q.dir;
		q.dir = p;
		p.esq = temp;
		return q;
	}
	
	public ARVORE rotacaoEsquerda(ARVORE p) {
		ARVORE q, temp;
		q = p.dir;
		temp = q.esq;
		q.esq = p;
		p.dir = temp;
		return q;
	}
}