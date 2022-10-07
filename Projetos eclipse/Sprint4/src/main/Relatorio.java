package main;

import java.util.Random;

import arvores.ABBCliente;
import arvores.AVLCliente;
import cliente.Cliente;

public class Relatorio {
	private Cliente[] dados;
	
	/* Gera um relat�rio com as compara��es de tempo de busca para AVL e ABB
	 * nrAmostras: N�mero de vetores para gerar
	 * nrElementos: N�mero de elementos por vetor
	 * nrBuscas: Quantos elementos buscar na �rvore */
	public void gerarRelatorio(int nrTestes, int nrElementos, int nrBuscas) {
		System.out.println("Gerando " + nrTestes + " testes de " + nrElementos + " elementos...");
		System.out.println("N�mero de pesquisas por teste: " + nrBuscas);
		
		/* declara��o de vari�veis */
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
			
			/* Gerando clientes aleat�rios e populando as �rvores */
			popularVetor(dados);
			popularABB(dados, abb);
			popularAVL(dados, avl);
			
			/* resetando o valor das somas */
			somaABB = somaAVL = minABB = minAVL = maxABB = maxAVL = 0;
			for(int j=0; j<nrBuscas; j++) {
				/* n� aleat�rio entre 0 e o tamanho m�ximo do vetor */
				ix = r.nextInt(nrElementos); 
				
				/* Registrando a qtde de compara��es realizadas */
				// Com dados aleat�rios (incluindo inexistentes)
				qtdeComparacoesAVL = avl.contaConsulta(new Cliente(i, r.nextInt(1000000), r.nextInt(20000)));
				qtdeComparacoesABB = abb.contaConsulta(new Cliente(i, r.nextInt(1000000), r.nextInt(20000)));
				
				// Somente com dados existentes em ambas as �rvores
				//qtdeComparacoesAVL = avl.contaConsulta(dados[ix]);
				//qtdeComparacoesABB = abb.contaConsulta(dados[ix]);
				
				/* definindo m�ximos e m�nimos iniciais*/
				if(j == 0) {
					minABB = maxABB = qtdeComparacoesABB;
					minAVL = maxAVL = qtdeComparacoesAVL;
				}
				
				/* verificando m�ximos e m�nimos */
				if(qtdeComparacoesABB > maxABB) maxABB = qtdeComparacoesABB;
				if(qtdeComparacoesABB < minABB) minABB = qtdeComparacoesABB;
				if(qtdeComparacoesAVL > maxAVL) maxAVL = qtdeComparacoesAVL;
				if(qtdeComparacoesAVL > minAVL) minAVL = qtdeComparacoesAVL;
				
				/* incrementando as somas */
				somaAVL += qtdeComparacoesAVL;
				somaABB += qtdeComparacoesABB;
			}
			/* calculando as m�dias */
			mediaAVL = somaAVL / nrBuscas;
			mediaABB = somaABB / nrBuscas;
			mediaABBTotal += mediaABB;
			mediaAVLTotal += mediaAVL;
			
			//TODO: terminar este relat�rio
			System.out.println("\nResultados do teste " + (i+1));
			System.out.println("M�dia de compara��es");
			System.out.println("ABB = " + String.format("%.2f", mediaABB) + "\tAVL = " + String.format("%.2f", mediaAVL));
		}
		mediaABBTotal /= nrTestes;
		mediaAVLTotal /= nrTestes;
		System.out.println("\nM�dia das compara��es dos " + (nrTestes) + " testes");
		System.out.println("ABB = " + String.format("%.2f", mediaABBTotal) + "\tAVL = " + String.format("%.2f", mediaAVLTotal));
		System.out.println("AVL " + String.format("%.2f", (mediaABBTotal/mediaAVLTotal)*100 - 100) + "% mais r�pida que a ABB");
	}
	
	/* Popula um vetor com 100 clientes aleat�rios */
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
