package tipoPilha;

public class TipoPilhaInt {

	public static final int N = 16;

	int[] dados = new int[N];
	int topo;

	public TipoPilhaInt() {
		topo = 0;
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

	public void push(int elem) {
		if (isFull() == false) {
			dados[topo] = elem;
			topo++;
		}
		else
			System.out.println("Stack Overflow");
	}

	public int top() {
		return (dados[topo - 1]);
	}
	
	public int pop() {
		topo--;
		return (dados[topo]);
	}
	
	public void esvazia() {
		while (!this.isEmpty())
			System.out.println("Valor retirado: " + this.pop());
	}
}
