package br.fiap.testes;

import br.fiap.listas.ListaIntCrescente;

public class ListaIntCrescenteMain {
    public static void main(String[] args) {
    	
        ListaIntCrescente lista = new ListaIntCrescente();
        
        for(int i=1; i<=10; i++) lista.insere(i);
        
        lista.printMaiores(5);
        System.out.println();
        System.out.println(lista.size());
        
       /* Scanner scn = new Scanner(System.in);
        
        System.out.println("Informe os valores");
        int valor = scn.nextInt();

        while(valor >= 0){
            lista.insere(valor);
            lista.show();
            System.out.println("Informe os valores");
            valor = scn.nextInt();
        }

        System.out.println("Informe o valor para remover");
        valor = scn.nextInt();
        while(valor >= 0){
            lista.remove(valor);
            lista.show();
            System.out.println("Informe o valor para remover");
            valor = scn.nextInt();
        }

        scn.close();*/
        
    }
}
