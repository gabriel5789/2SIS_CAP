package com.fiap.ex4;

import javax.swing.JOptionPane;

import com.fiap.fila.TipoFilaInt;

public class Main {
	public static void main(String[] args) {
		TipoFilaInt memoria = new TipoFilaInt();
		int opcao;
		String opcoes[] = {"Submete processo", "Processa", "Sair"};
		String simNao[] = {"Sim", "Não"};
		
		do {
			opcao=JOptionPane.showOptionDialog(null, "Selecione uma opcao", 
					"Processamento", 0, JOptionPane.QUESTION_MESSAGE, null, 
					opcoes, memoria);
			if(opcao==0)
				memoria.enqueue(Integer.parseInt(JOptionPane.showInputDialog(
						null, "Digite o PID do processo", "Submissão de processo", 
						JOptionPane.QUESTION_MESSAGE
				)));
			if(opcao==1) {
				if(!memoria.isEmpty()) {
					opcao = JOptionPane.showOptionDialog(null, "O processo " + memoria.first() + " foi concluído?", 
							"Processamento", 0, 
							JOptionPane.QUESTION_MESSAGE, null, simNao, 0);
					if(opcao==0) {
						JOptionPane.showMessageDialog(null, "Processo " + memoria.dequeue() + " concluido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Processo "+ memoria.first() +" foi pro final da fila", "OK", JOptionPane.WARNING_MESSAGE, null);
						memoria.enqueue(memoria.dequeue());
					}
					
					opcao=0;
				} else 
					JOptionPane.showMessageDialog(null, 
							"A fila de processamento está vazia :D", 
							"Nenhum atendimento", 
							JOptionPane.INFORMATION_MESSAGE);
			}
			if(opcao==2 && !memoria.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ainda há processos na fila!", 
						"Erro", JOptionPane.ERROR_MESSAGE);
				opcao=0;
			}
		} while(opcao!=2);
	}
}
