package br.pan.pilha;

public class TipoPilhaMensagens {
	
	public int N;
	String[] dados;
	int topo;

	public TipoPilhaMensagens(int size) {
		topo = 0;
		N = size;
		dados = new String[N];
	}

	public boolean isEmpty() {
		if (topo == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (topo == N)
			return true;
		else
			return false;
	}

	public void push(String elem) {
		if (isFull() == false) {
			dados[topo] = elem;
			topo++;
		}
		else
			System.out.println("Stack Overflow");
	}

	public String top() {
		return (dados[topo - 1]);
	}
	
	public String pop() {
		topo--;
		return (dados[topo]);
	}
	
	public void esvazia() {
		while (!this.isEmpty())
			System.out.println("Valor retirado: " + this.pop());
	}
}
