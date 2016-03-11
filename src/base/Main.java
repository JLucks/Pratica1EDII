/**
 * Classe principal que cria a janela e inicia o programa.
 */
package base;

import interfaces.*;

import javax.swing.JFrame;

public class Main {
	//Variaveis
	public static final String nome = "Algoritmos de Ordenação";	//Nome da janela
	public static JFrame janela = new JFrame(nome);
	public static void main(String[] args) {
		janela.setSize(720,400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.add(new WindowMain());
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

}
