package br.fiap.fila;

public class FilaMensagens {
		public static final int N = 16;
		Mensagem[] dados = new Mensagem[N];
		int fim;
		int inicio;
		int cont;
		
		public void init() {
			fim = inicio = cont = 0;
		}
		
		public void enqueue(Mensagem element) {
			if(this.isFull()) {
				System.out.println("FILA CHEIA!");
				return;
			}
			dados[fim] = element;
			cont++;
			fim = (fim+1) % N;
		}
		
		public Mensagem dequeue() {
			if(this.isEmpty()) return null;
			Mensagem retorno = dados[inicio];
			inicio = (inicio+1) % N;
			cont--;
			return retorno;
		}
		
		public Mensagem first() {
			return dados[inicio];
		}
		
		public boolean isEmpty() {
			if(cont==0)
				return true;
			return false;
		}
		
		public boolean isFull() {
			if(cont==N)
				return true;
			return false;
		}
		
}
