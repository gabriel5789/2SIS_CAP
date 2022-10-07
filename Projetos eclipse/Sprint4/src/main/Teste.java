package main;

import arvores.ABBCliente;
import arvores.AVLCliente;
import cliente.Cliente;

public class Teste {

	public static void main(String[] args) {
		Cliente cl[] = {
				new Cliente(111, 111, 111),
				new Cliente(222, 222, 222),
				new Cliente(333, 333, 333),
				new Cliente(444, 444, 444),
				new Cliente(555, 555, 555),
				new Cliente(666, 666, 666),
				new Cliente(777, 777, 777)
		};
		AVLCliente avl = new AVLCliente();
		ABBCliente abb = new ABBCliente();
		
		for (Cliente cliente : cl) {
			avl.inserir(cliente);
			abb.inserir(cliente);
		}
		
		avl.listaEmOrdem();
		abb.listaEmOrdem();
		
		System.out.println("\nProcurando por " + cl[6]);
		System.out.println(avl.contaConsulta(cl[6]) + "\n" + avl.consulta(cl[4]));
		System.out.println(abb.contaConsulta(cl[6]) + "\n" + abb.consulta(cl[4]));
		
		System.out.println("\nAgora com dado inexistente");
		Cliente inexistente = new Cliente(1, 1, 1);
		System.out.println(abb.contaConsulta(inexistente) + "\n" + abb.consulta(inexistente));
		System.out.println(avl.contaConsulta(inexistente) + "\n" + avl.consulta(inexistente));
		
	}

}
