package algoritmosOrdenacao;

import base.*;

public class InsertionSort {
	//Variaveis
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	public InsertionSort(Order order){
		this.order = order;	//Inicializa a classe de comparação
		this.powers = 0L;
	}
	
	//Metodo unico do insertionsort
	public Camp[] insertionSort(Camp C[]){	//Tem como entrada o arranjo a ser ordenado
		//Variaveis
		int j;	//Variavel para percorre as posições anteriores a chave
		Camp key;	//Guarda o valor do campo escolhido como chave
		for(int i = 1; i < C.length; i++){	//Percorre a partir da segunda posição do arranjo ate o fim do mesmo
			key = C[i];	//Guarda o valor da chave
			j = i - 1;	//Seleciona a posição anterior a chave
			while(j >= 0 && order.compareValue(C[j], key)){	//Enquanto as posições anteriores estiverem dentro do arranjo e também enquanto o dado anterior for maior que a chave
				C[j+1] = C[j];	//Passa para frente o maior
				this.powers++;
				j--;	//Volta uma posição
			}
			C[j+1] = key;	//Coloca o dado da chave na posição correta
			this.powers++;
		}
		System.out.println("Nº de Atribuições: "+this.powers);
		return C;	//Retorna o arranjo ordenado
	}
}
