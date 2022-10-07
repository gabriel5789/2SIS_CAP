package com.fiap.ex3;

import javax.swing.JOptionPane;

import com.fiap.fila.TipoFilaInt;

public class Main {

	public static void main(String[] args) {
		TipoFilaInt memoria = new TipoFilaInt();
		int opcao;
		String opcoes[] = {"Cadastrar", "Atender", "Sair"};
		
		do {
			opcao=JOptionPane.showOptionDialog(null, "Selecione uma opcao", 
					"Atendimento", 0, JOptionPane.QUESTION_MESSAGE, null, 
					opcoes, memoria);
			if(opcao==0)
				memoria.enqueue(Integer.parseInt(JOptionPane.showInputDialog(
						null, "Digite o RM do aluno", "Cadastro", 
						JOptionPane.QUESTION_MESSAGE
				)));
			if(opcao==1) {
				if(!memoria.isEmpty())
					JOptionPane.showMessageDialog(null, "Atendendo aluno de RM "
				+ memoria.dequeue(), "Atendimento iniciado", 
				JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, 
							"A fila de atendimento está vazia :D", 
							"Nenhum atendimento", 
							JOptionPane.INFORMATION_MESSAGE);
			}
			if(opcao==2 && !memoria.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ainda há alunos na fila!", 
						"Erro", JOptionPane.ERROR_MESSAGE);
				opcao=0;
			}
		} while(opcao!=2);
		
	}

}
