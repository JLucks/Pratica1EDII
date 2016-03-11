package algoritmosOrdenacao;

import base.*;

public class QuickSort {
	//Variaveis
	private int mode;	//Guarda o modo do pivo se é inicio, meio, fim
	private Order order;	//Classe que provem o metodo para comparar com o campo determinado pelo usuario
	private long powers;
	
	public QuickSort(int mode, Order order){
		this.mode = mode;	//Inicializa o modo do pivo
		this.order = order;	//Inicializa a classe de comparação
		this.powers = 0L;
	}
	
	//Metodo base do quicksort
	public long quickSort(Camp C[], int start, int end){	//Tem como entrada o arranjo, uma posição inicial e uma final
		if(start < end){	//Verifica se a posição inicial não chegou ao fim 
			int posPivo = this.selectionMode(C, start, end);	//Guarda o pivo do metodo particiona de um modo selecionado
			this.quickSort(C, start, posPivo - 1);	//Rechama-se passando o arranjo, a posição inicial até a anterior ao pivo
			this.quickSort(C, posPivo + 1, end);	//Rechama-se passando o arranjo, a posição posterior ao pivo até o fim
		}
		return this.powers;
	}
	
	//Metodo que seleciona o metodo particiona
	private int selectionMode(Camp C[], int start, int end){	//Tem como entrada o arranjo, uma posição inicial e uma final
		if(mode == 0){
			return this.partitionsStart(C, start, end);	//Particiona com o pivo no inicio
		}
		else if(mode == 1){
			return this.partitionsHalf(C, start, end);	//Particiona com o pivo no meio
		}
		else{
			return this.partitionsEnd(C, start, end);	//Particiona com o pivo no fim
		}
	}
	
	//Metodo particiona com o pivo no inicio
	private int partitionsStart(Camp C[], int start, int end){	//Tem como entrada o arranjo, uma posição inicial e uma final
		//Variaveis
		Camp pivo = C[start], aux;	//Pivo é a chave e aux auxila na troca dos dados
		int i = start + 1, f = end;	//i para percorrer da posição apos o pivo para o fim, f para percorre do fim para o inicio
		while(i <= f){	//Percorre ate i e f se inverterem
			if(order.compareValueWithEqual(pivo, C[i])){	//Verifica se o dado da posição i é menor que o pivo
				i++;
			}
			else if(order.compareValue(C[f], pivo)){	//Verifica se o dado da posição f é maior que o pivo
				f--;
			}
			else{
				//Troca os dados das poisções i e f
				aux = C[i];
				C[i] = C[f];
				C[f] = aux;
				this.powers+=2L;
				i++;
				f--;
			}
		}
		//Troca os dados do pivo com o da posição f
		C[start] = C[f];
		C[f] = pivo;
		this.powers+=2L;
		return f; //Retorna a posição do pivo
	}
	
	private int partitionsEnd(Camp C[], int start, int end){	//Tem como entrada o arranjo, uma posição inicial e uma final
		//Variaveis
		Camp pivo = C[end], aux;	//Pivo é a chave e aux auxila na troca dos dados
		int i = start, f = end - 1;	//i para percorrer da posição do pivo para o fim, f para percorre do antecessor do fim para o inicio
		while(i <= f){	//Percorre ate i e f se inverterem
			if(order.compareValueWithEqual(pivo, C[i])){	//Verifica se o dado da posição i é menor que o pivo
				i++;
			}
			else if(order.compareValue(C[f], pivo)){	//Verifica se o dado da posição f é maior que o pivo
				f--;
			}
			else{
				//Troca os dados das poisções i e f
				aux = C[i];
				C[i] = C[f];
				C[f] = aux;
				this.powers+=2L;
				i++;
				f--;
			}
		}
		//Troca os dados do pivo com o da posição i
		C[end] = C[i];
		C[i] = pivo;
		this.powers+=2L;
		return i;	//Retorna a posição do pivo
	}
	
	private int partitionsHalf(Camp C[], int start, int end){	//Tem como entrada o arranjo, uma posição inicial e uma final
		//Variaveis
		int i = start, f = end, meio = (start + end)/2;	//i para percorrer da posição do pivo para o fim, f para percorre do fim para o inicio
		Camp pivo = C[meio],aux;	//Pivo é a chave e aux auxila na troca dos dados
		while(i <= f){	//Percorre ate i e f se inverterem
			if(order.compareValueWithEqual(pivo, C[i])){	//Verifica se o dado da posição i é menor que o pivo
				i++;
			}
			else if(order.compareValue(C[f], pivo)){	//Verifica se o dado da posição f é maior que o pivo
				f--;
			}
			else{
				if(f!=meio){
					//Troca os dados das poisções i e f
					aux = C[i];
					C[i] = C[f];
					C[f] = aux;
					this.powers+=2L;
				}
				i++;
				f--;
			}
		}
		//Troca os dados do pivo com o da posição i
		C[meio] = C[f];
		C[f] = pivo;
		this.powers+=2L;
		return f;	//Retorna a posição do pivo
	}
}
