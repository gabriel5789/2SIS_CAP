package main;

public class Main {
	
	public static void main(String[] args) {
		Relatorio rl = new Relatorio();
		// (n�mero de testes, n�meros de elementos por teste, n�mero de buscas por teste)
		rl.gerarRelatorio(30, 1000, 300);
	}

}
