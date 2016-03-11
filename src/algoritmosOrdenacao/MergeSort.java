package algoritmosOrdenacao;

import base.*;

public class MergeSort {
	//Variaveis
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	public MergeSort(Order order){
		this.order = order;	//Inicializa a classe de comparação
		this.powers = 0L;
	}
	
	//Metodo base do mergesort
	public Camp[] mergeSort(Camp C[]){	//Tem como entrada o arranjo
		//Variaveis
		Camp temp[] = new Camp[C.length];	//Cria um arranjo temporario de mesmo tamanho do arranjo a ser ordenado
		C = this.mergeMain(C,temp,0,C.length - 1);	//Chamada ao metodo que fragmenta o arranjo
		System.out.println("Nº de Atribuições: "+this.powers);
		return C;	//retorna o arranjo já ordenado 
	}
	
	//Metodo que fragmenta o arranjo
	public Camp[] mergeMain(Camp C[], Camp temp[], int left, int right){	//Tem como entrada o arranjo, o arranjo temporario, a primeira posição e a ultima que irão ser ordenadas
		//Variaveis
		int half;	//Guarda a posição intermediaria do arranjo
		if(left < right){	//Verifica se a inicial não ultrapassou o fim
			half = (left + right) / 2;	//posicao intermediaria
			this.mergeMain(C, temp, left, half);	//Fragmenta do inicio ao meio
			this.mergeMain(C, temp, half + 1, right);	//Fragmenta do meio ao fim
			this.merge(C, temp, left, half + 1, right);	//Chamada ao metodo que intecalar no arranjo os fragmentos ordenados
		}
		return C;	//retorna o arranjo semi-ordenado
	}
	
	//Metodo que intercalar ordenadamente
	private void merge(Camp C[], Camp temp[], int left, int right, int end){	//Tem como entrada o arranjo, o arranjo temporario, a posição inicial para intercalação, a posição do meio e a final
		//Variaveis
		int leftEnd = right - 1, tPos = left, numEle = end - left + 1;	//leftEnd limite ate o meio, tpos posicao do arranjo temporario, numEle o total de elementos
		while(left <= leftEnd && right <= end){	//Percorre do inicio ao meio e do meio ao fim ate que um alcance o limite
			if(order.compareValueWithEqual(C[right], C[left])){	//Verifica quem é maio o da esquerda ou o da direita
				temp[tPos] = C[left];	//Guarda no arranjo temporario caso seja o menor o da esquerda
				left++;
				this.powers++;
			}
			else{
				temp[tPos] = C[right];	//Guarda no arranjo temporario caso seja o da direita
				right++;
				this.powers++;
			}
			tPos++;
		}
		while(left <= leftEnd){	//Preenche com o resto da esquerda
			temp[tPos] = C[left];
			this.powers++;
			left++;
			tPos++;
		}
		while(right <= end){	//Preenche com resto da direita
			temp[tPos] = C[right];
			this.powers++;
			right++;
			tPos++;
		}
		for(int i = 0; i < numEle; i++, end--){	//Percorre o total de elementos
			C[end] = temp[end];	//Carrega o arranjo temporario no principal
			this.powers++;
		}
	}
	
}
