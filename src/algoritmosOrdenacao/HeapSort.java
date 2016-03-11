package algoritmosOrdenacao;

import base.*;

public class HeapSort {
	//Variaveis
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	//Construtor
	public HeapSort(Order order){
		this.order = order;		//Inicializa a classe de comparação
		this.powers = 0L;
	}
	
	//Metodo principal do heapsort
	public void heapSort(Camp C[], int tam){	//Tem como entrada o arranjo e a ultima posicão do vetor o tamanho - 1
		//Variaveis
		Camp aux;	//Variavel para auxiliar a troca de dados
		this.buildMaxHeap(C, tam);	//Chamada ao metodo para criação da arvore
		for(int i = tam; i >=0; i--){	//Percorre da ultima posicão a primeira
			//troca da 1 posição e da ultima
			aux = C[0];
			C[0] = C[i];
			C[i] = aux;
			this.powers+=2L;
			this.maxHeapFy(C, 0, i-1);	//Chamada ao metodo para normalizar a arvore para MaxHeap
		}
		System.out.println("Nº de Atribuições: "+this.powers);
	}
	
	//Metodo que simula a criação de uma arvore MaxHeap
	private void buildMaxHeap(Camp C[], int tam){	//Tem como entrada o arranjo e a ultima posicão do vetor o tamanho - 1
		for(int i = tam/2; i >= 0; i--){	//Percorre a apartir da posição intermediaria
			this.maxHeapFy(C, i, tam);	//Chamada ao metodo para normalizar a arvore para MaxHeap
		}
	}
	
	//Metodo para normalizar a arvore para MaxHeap
	private void maxHeapFy(Camp C[], int dad, int tam){	//Tem como entrada o arranjo, a posição do nó pai e a ultima posicão do vetor o tamanho - 1
		//Variaveis
		int l = 2 * dad, r = (2 * dad)+ 1, largest;	// l representa o nó filho a esquerda, r o nó filho a direita e largest para guarda o maior entre o nó pai e nóis filhos  
		Camp aux;	//Variavel para auxiliar na troca entre os nós caso o nó filho seja maior que o nó pai
		if(l <= tam && order.compareValue(C[l], C[dad])){	//Verifica se a posição para o nó filho a esquerda é valida no arranjo e também se o nó filho é maior que o nó pai 
			largest = l;	//Guarda a posição do nó filho a esquerda caso ele seja maior que o nó pai
		}
		else{
			largest = dad;	//Guarda a posição do nó pai caso ele seja o maior
		}
		if(r <= tam && order.compareValue(C[r], C[largest])){	//Verifica se a posição para o nó filho a direita é valida no arranjo e também se o nó filho é maior que o nó maior anterior 
			largest = r;	//Guarda a posição do nó filho a direita caso ele seja maior que o nó pai
		}
		if(largest != dad){	//Verifica se a posição do maior é do nó pai
			//Troca o dado do nó pai com a do nó filho maior 
			aux = C[dad];
			C[dad] = C[largest];
			C[largest] = aux;
			this.powers+=2L;
			this.maxHeapFy(C, largest, tam);	//Chamada ao metodo para normalizar a arvore para MaxHeap apos a troca
		}
	}
	
}
