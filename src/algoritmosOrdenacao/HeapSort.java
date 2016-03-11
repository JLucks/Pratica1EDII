package algoritmosOrdenacao;

import base.*;

public class HeapSort {
	//Variaveis
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	//Construtor
	public HeapSort(Order order){
		this.order = order;		//Inicializa a classe de compara��o
		this.powers = 0L;
	}
	
	//Metodo principal do heapsort
	public void heapSort(Camp C[], int tam){	//Tem como entrada o arranjo e a ultima posic�o do vetor o tamanho - 1
		//Variaveis
		Camp aux;	//Variavel para auxiliar a troca de dados
		this.buildMaxHeap(C, tam);	//Chamada ao metodo para cria��o da arvore
		for(int i = tam; i >=0; i--){	//Percorre da ultima posic�o a primeira
			//troca da 1 posi��o e da ultima
			aux = C[0];
			C[0] = C[i];
			C[i] = aux;
			this.powers+=2L;
			this.maxHeapFy(C, 0, i-1);	//Chamada ao metodo para normalizar a arvore para MaxHeap
		}
		System.out.println("N� de Atribui��es: "+this.powers);
	}
	
	//Metodo que simula a cria��o de uma arvore MaxHeap
	private void buildMaxHeap(Camp C[], int tam){	//Tem como entrada o arranjo e a ultima posic�o do vetor o tamanho - 1
		for(int i = tam/2; i >= 0; i--){	//Percorre a apartir da posi��o intermediaria
			this.maxHeapFy(C, i, tam);	//Chamada ao metodo para normalizar a arvore para MaxHeap
		}
	}
	
	//Metodo para normalizar a arvore para MaxHeap
	private void maxHeapFy(Camp C[], int dad, int tam){	//Tem como entrada o arranjo, a posi��o do n� pai e a ultima posic�o do vetor o tamanho - 1
		//Variaveis
		int l = 2 * dad, r = (2 * dad)+ 1, largest;	// l representa o n� filho a esquerda, r o n� filho a direita e largest para guarda o maior entre o n� pai e n�is filhos  
		Camp aux;	//Variavel para auxiliar na troca entre os n�s caso o n� filho seja maior que o n� pai
		if(l <= tam && order.compareValue(C[l], C[dad])){	//Verifica se a posi��o para o n� filho a esquerda � valida no arranjo e tamb�m se o n� filho � maior que o n� pai 
			largest = l;	//Guarda a posi��o do n� filho a esquerda caso ele seja maior que o n� pai
		}
		else{
			largest = dad;	//Guarda a posi��o do n� pai caso ele seja o maior
		}
		if(r <= tam && order.compareValue(C[r], C[largest])){	//Verifica se a posi��o para o n� filho a direita � valida no arranjo e tamb�m se o n� filho � maior que o n� maior anterior 
			largest = r;	//Guarda a posi��o do n� filho a direita caso ele seja maior que o n� pai
		}
		if(largest != dad){	//Verifica se a posi��o do maior � do n� pai
			//Troca o dado do n� pai com a do n� filho maior 
			aux = C[dad];
			C[dad] = C[largest];
			C[largest] = aux;
			this.powers+=2L;
			this.maxHeapFy(C, largest, tam);	//Chamada ao metodo para normalizar a arvore para MaxHeap apos a troca
		}
	}
	
}
