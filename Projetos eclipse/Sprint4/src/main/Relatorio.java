package main;

import java.util.Random;

import arvores.ABBCliente;
import arvores.AVLCliente;
import cliente.Cliente;

public class Relatorio {
	private Cliente[] dados;
	
	/* Gera um relatório com as comparações de tempo de busca para AVL e ABB
	 * nrAmostras: Número de vetores para gerar
	 * nrElementos: Número de elementos por vetor
	 * nrBuscas: Quantos elementos buscar na árvore */
	public void gerarRelatorio(int nrTestes, int nrElementos, int nrBuscas) {
		System.out.println("Gerando " + nrTestes + " testes de " + nrElementos + " elementos...");
		System.out.println("Número de pesquisas por teste: " + nrBuscas);
		
		/* declaração de variáveis */
		int minABB, maxABB, somaABB, qtdeComparacoesABB;
		int minAVL, maxAVL, somaAVL, qtdeComparacoesAVL;
		double mediaAVL, mediaABB;
		double mediaABBTotal=0, mediaAVLTotal=0;
		ABBCliente abb; AVLCliente avl;
		Random r = new Random(); int ix;
		
		for(int i=0; i<nrTestes; i++) {
			dados = new Cliente[nrElementos];
			abb = new ABBCliente();
			avl = new AVLCliente();
			
			/* Gerando clientes aleatórios e populando as árvores */
			popularVetor(dados);
			popularABB(dados, abb);
			popularAVL(dados, avl);
			
			/* resetando o valor das somas */
			somaABB = somaAVL = minABB = minAVL = maxABB = maxAVL = 0;
			for(int j=0; j<nrBuscas; j++) {
				/* nº aleatório entre 0 e o tamanho máximo do vetor */
				ix = r.nextInt(nrElementos); 
				
				/* Registrando a qtde de comparações realizadas */
				// Com dados aleatórios (incluindo inexistentes)
				qtdeComparacoesAVL = avl.contaConsulta(new Cliente(i, r.nextInt(1000000), r.nextInt(20000)));
				qtdeComparacoesABB = abb.contaConsulta(new Cliente(i, r.nextInt(1000000), r.nextInt(20000)));
				
				// Somente com dados existentes em ambas as árvores
				//qtdeComparacoesAVL = avl.contaConsulta(dados[ix]);
				//qtdeComparacoesABB = abb.contaConsulta(dados[ix]);
				
				/* definindo máximos e mínimos iniciais*/
				if(j == 0) {
					minABB = maxABB = qtdeComparacoesABB;
					minAVL = maxAVL = qtdeComparacoesAVL;
				}
				
				/* verificando máximos e mínimos */
				if(qtdeComparacoesABB > maxABB) maxABB = qtdeComparacoesABB;
				if(qtdeComparacoesABB < minABB) minABB = qtdeComparacoesABB;
				if(qtdeComparacoesAVL > maxAVL) maxAVL = qtdeComparacoesAVL;
				if(qtdeComparacoesAVL > minAVL) minAVL = qtdeComparacoesAVL;
				
				/* incrementando as somas */
				somaAVL += qtdeComparacoesAVL;
				somaABB += qtdeComparacoesABB;
			}
			/* calculando as médias */
			mediaAVL = somaAVL / nrBuscas;
			mediaABB = somaABB / nrBuscas;
			mediaABBTotal += mediaABB;
			mediaAVLTotal += mediaAVL;
			
			//TODO: terminar este relatório
			System.out.println("\nResultados do teste " + (i+1));
			System.out.println("Média de comparações");
			System.out.println("ABB = " + String.format("%.2f", mediaABB) + "\tAVL = " + String.format("%.2f", mediaAVL));
		}
		mediaABBTotal /= nrTestes;
		mediaAVLTotal /= nrTestes;
		System.out.println("\nMédia das comparações dos " + (nrTestes) + " testes");
		System.out.println("ABB = " + String.format("%.2f", mediaABBTotal) + "\tAVL = " + String.format("%.2f", mediaAVLTotal));
		System.out.println("AVL " + String.format("%.2f", (mediaABBTotal/mediaAVLTotal)*100 - 100) + "% mais rápida que a ABB");
	}
	
	/* Popula um vetor com 100 clientes aleatórios */
	private void popularVetor(Cliente[] vetor) {
		for(int i=0; i < vetor.length; i++) {
			Random r = new Random();
			vetor[i] = new Cliente(i, r.nextInt(1000000), r.nextInt(20000));
		}
	}
	
	/* Popula uma ABB com os dados de um vetor */
	private void popularABB(Cliente[] vetor, ABBCliente abb) {
		for(int i=0; i < vetor.length; i++) {
			abb.inserir(vetor[i]);
		}
	}
	
	/* Popula uma AVL com os dados de um vetor */
	private void popularAVL(Cliente[] vetor, AVLCliente avl) {
		for(int i=0; i < vetor.length; i++) {
			avl.inserir(vetor[i]);
		}
	}
	
}
