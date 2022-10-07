package com.fiap.arvore;

public class ArvoreBinaria<T> {
    NO<T> root;
    public static void inOrdem(NO p){
        if(p != null) {
            if(p.esq != null)
                inOrdem(p.esq);
            System.out.println(" " + p.dado);
            if(p.dir != null)
                inOrdem(p.dir);
        }
    }

}
