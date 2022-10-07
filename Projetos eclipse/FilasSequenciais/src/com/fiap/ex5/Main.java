package com.fiap.ex5;

import javax.swing.JOptionPane;

import com.fiap.fila.TipoFilaString;

public class Main {
	public static void main(String[] args) {
		TipoFilaString memoria = new TipoFilaString();
		int opcao;
		String opcoes[] = {"Cadastrar", "Atender", "Sair"};
		
		do {
			opcao=JOptionPane.showOptionDialog(null, "Selecione uma opcao", 
					"Atendimento", 0, JOptionPane.QUESTION_MESSAGE, null, 
					opcoes, memoria);
			if(opcao==0)
				memoria.enqueue(JOptionPane.showInputDialog(
						null, "Digite o nome do paciente", "Cadastro", 
						JOptionPane.QUESTION_MESSAGE
				));
			if(opcao==1) {
				if(!memoria.isEmpty())
					JOptionPane.showMessageDialog(null, "Atendendo paciente de nome "
				+ memoria.dequeue(), "Atendimento iniciado", 
				JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, 
							"A fila de atendimento está vazia :D", 
							"Nenhum atendimento", 
							JOptionPane.INFORMATION_MESSAGE);
			}
			if(opcao==2 && !memoria.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ainda há pacientes na fila!", 
						"Erro", JOptionPane.ERROR_MESSAGE);
				opcao=0;
			}
		} while(opcao!=2);
	}
}
