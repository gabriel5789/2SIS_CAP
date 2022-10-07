package main;

public class Main {
	
	public static void main(String[] args) {
		Relatorio rl = new Relatorio();
		// (número de testes, números de elementos por teste, número de buscas por teste)
		rl.gerarRelatorio(30, 1000, 300);
	}

}
