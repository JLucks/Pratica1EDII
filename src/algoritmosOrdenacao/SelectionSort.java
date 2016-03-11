package algoritmosOrdenacao;

import base.*;

public class SelectionSort {
	//Variaveis
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	public SelectionSort(Order order){
		this.order = order;	//Inicializa a classe de comparação
		this.powers = 0L;
	}
	
	//Metodo unico do selectionsort
	public Camp[] selectionSort(Camp C[]){	//Tem como entrada o arranjo
		//Variaveis
		Camp aux;	//Para auxiliar a troca dos dados
		int key;	//Posição chave
		for(int i = 0; i < C.length; i++){	//Percorre da 1 posição a ultima
			key = i;	//Assume que a posição é a meno
			for(int j = i + 1; j < C.length; j++){	//Percorre da posicao posterior ate o fim
				if(order.compareValue(C[key], C[j])){	//Verifica se os dados da posição é menor que a chave
					key = j;	//Guarda a posição dos dados menores
				}
			}
			//Troca os dados da posição ordenada com os dados da chave apropriada
			aux = C[i];
			C[i] = C[key];
			C[key] = aux;
			this.powers+=2L;
		}
		System.out.println("Nº de Atribuições: "+this.powers);
		return C;	//Retorna o arranjo ordenado
	}
}
