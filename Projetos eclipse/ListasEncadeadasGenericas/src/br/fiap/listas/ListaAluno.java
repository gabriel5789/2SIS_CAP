package br.fiap.listas;

import br.fiap.aluno.Aluno;

public class ListaAluno {
	
    private class NO{
        Aluno dado;
        NO prox;
    }

    NO lista = null;

    public void insere(Aluno elem){
        
        NO novo = new NO();
        novo.dado = elem;

        if(lista == null){
            novo.prox = null;
            lista = novo;
        } else{
            if(novo.dado.getRm() < lista.dado.getRm()){
                novo.prox = lista;
                lista = novo;
            } else{
                NO aux = lista;
                boolean achou = false;
                while((aux.prox != null) && (achou == false)){
                    if(aux.prox.dado.getRm() < novo.dado.getRm())
                        aux = aux.prox;
                    else
                        achou = true;
                }
                novo.prox = aux.prox;
                aux.prox = novo;
            }
        }
    }

    public void remove(int valor){
        if(lista != null){
            if(lista.dado.getRm() == valor)
                lista = lista.prox;
            else{
                NO aux = lista;
                boolean achou = false;
                while(aux.prox != null && !achou){
                    if(aux.prox.dado.getRm() == valor){
                        achou = true;
                    }else{
                        aux = aux.prox;
                    }
                }
                if(achou)
                    aux.prox = aux.prox.prox;
                else
                System.out.println("Valor não encontrado!");
            }
        }else{
            System.out.println("A lista está vazia");
        }
    }

    public void show(){
        NO aux = lista;
        while(aux != null){
            System.out.print(aux.dado + "\t");
            aux = aux.prox;
        }
        System.out.println();
    }
    
    public int size() {
    	int size = 0;
    	NO node = this.lista;
    	while(node != null) {
    		node = node.prox;
    		size++;
    	}
    	return size;
    }
    
    public void printMaiores(int num) {
    	NO node = this.lista;
    	while(node != null) {
    		if(node.dado.getRm() > num)
    			System.out.print(node.dado + " ");
    		node = node.prox;
    	}
    }
    
    public Double select(int rm) {
    	NO node = this.lista;
    	while(node != null) {
    		if(node.dado.getRm() == rm) {
    			return node.dado.getMedia();
    		}
    	}
    	return null;
    }
}
