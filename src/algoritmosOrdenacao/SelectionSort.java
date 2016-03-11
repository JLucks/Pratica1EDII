package algoritmosOrdenacao;

import base.*;

public class SelectionSort {
	//Variaveis
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	public SelectionSort(Order order){
		this.order = order;	//Inicializa a classe de compara��o
		this.powers = 0L;
	}
	
	//Metodo unico do selectionsort
	public Camp[] selectionSort(Camp C[]){	//Tem como entrada o arranjo
		//Variaveis
		Camp aux;	//Para auxiliar a troca dos dados
		int key;	//Posi��o chave
		for(int i = 0; i < C.length; i++){	//Percorre da 1 posi��o a ultima
			key = i;	//Assume que a posi��o � a meno
			for(int j = i + 1; j < C.length; j++){	//Percorre da posicao posterior ate o fim
				if(order.compareValue(C[key], C[j])){	//Verifica se os dados da posi��o � menor que a chave
					key = j;	//Guarda a posi��o dos dados menores
				}
			}
			//Troca os dados da posi��o ordenada com os dados da chave apropriada
			aux = C[i];
			C[i] = C[key];
			C[key] = aux;
			this.powers+=2L;
		}
		System.out.println("N� de Atribui��es: "+this.powers);
		return C;	//Retorna o arranjo ordenado
	}
}
