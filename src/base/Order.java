/**
 * Classe que chama o algoritmo escolhido e provem o metodo de comparaçã.
 */
package base;

import algoritmosOrdenacao.*;

public class Order {
	//Variaveis
	private int camp;	//Campo que será ordenado
	private long comparisons;
	
	//Metodo de seleção do algoritmo de ordenação
	public String orderString(String label, int camp, int algoritm, int modeQuick){	//Recebe uma String, o campo para comparação, o algoritmo a ser utilizado, e modo do algoritmo
		//Variaveis
		Camp C[] = this.stringToArray(label);	//Chamada ao metodo que transforma a string em um arranjo
		this.camp = camp;	//Inicializa o campo de comparação
		long timeStart=0, timeEnd=0;
		System.out.println("Alogoritmo:"+algoritm);
		this.comparisons = 0L;
		switch(algoritm){	//Verifica qual algoritmo
		case 1:
			timeStart = System.currentTimeMillis();
			C = new InsertionSort(this).insertionSort(C);	//Chamada ao insertionsort
			timeEnd = System.currentTimeMillis();
			break;
		case 2:
			timeStart = System.currentTimeMillis();
			C = new SelectionSort(this).selectionSort(C);	//Chamada ao selectionsort
			timeEnd = System.currentTimeMillis();
			break;
		case 3:
			timeStart = System.currentTimeMillis();
			System.out.println("Nº de Atribuições: "+new QuickSort(modeQuick,this).quickSort(C, 0, C.length - 1));	//Chamada ao quicksort
			timeEnd = System.currentTimeMillis();
			break;
		case 4:
			timeStart = System.currentTimeMillis();
			C = new MergeSort(this).mergeSort(C);	//Chamada ao mergesort
			timeEnd = System.currentTimeMillis();
			break;
		case 5:
			timeStart = System.currentTimeMillis();
			new HeapSort(this).heapSort(C, C.length-1);	//Chamada ao heapsort
			timeEnd = System.currentTimeMillis();
			break;
		default:
			System.err.println("Parametro para algoritmo, descolhecido!");
		}
		System.out.println("Nº de Comparações: "+this.comparisons);
		System.out.println("Tempo de Execução: "+(timeEnd-timeStart)*0.001);
		return this.ArrayToString(C);	//retorna o resultado da chamada a função que transforma o arranjo em string 
	}
	
	//Metodo que transforma a string em arranjo
	public Camp[] stringToArray(String label){	//Tem como entrada uma string
		//Variaveis
		String camps[] = label.split("//");	//Quebra a string pelo marcador de Campos
		Camp C[] = new Camp[camps.length];	//Cria o arranjo
		for(int i = 0; i < camps.length; i++){
			String camp[] = camps[i].split(";");	//Quebra os campos em campo
			C[i] = new Camp(camp[0],camp[1]);	//Adiciona os campos no arranjo
		}
		return C;	//Retorna o arranjo
	}
	
	//Metodo que transforma o arranjo em string
	public String ArrayToString(Camp C[]){	//Tem como entrada o arranjo
		//Variaveis
		String label = new String();	//Cria a string
		for(int i = 0; i < C.length; i++){
			label+= C[i].getCamp1()+";"+C[i].getCamp2()+"//";	//Adiciona os dados do arranjo a string
		}
		return label;	//Retorna a string
	}
	
	//Metodo que compara se o elemento A > elemento B
	public boolean compareValue(Object elementA, Object elementB){	//Tem como entrada o elemento A e o B
		//Variaveis
		Camp A = (Camp) elementA, B = (Camp) elementB;	//Faz o cashing dos elementos
		this.comparisons++;
		if(this.camp == 0){	//Testa qual o campo a ser comparado
			if(A.getCamp1().compareTo(B.getCamp1()) > 0){	//Compara os dados pela ordem alfanumerica
				return true;	
			}
		}
		else{
			if(A.getCamp2().compareTo(B.getCamp2()) > 0){
				return true;
			}	
		}
		return false;
	}
	
	//Metodo que compara se o elemento A >= elemento B
	public boolean compareValueWithEqual(Object elementA, Object elementB){	//Tem como entrada o elemento A e o B
		//Variaveis
		Camp A = (Camp) elementA, B = (Camp) elementB;	//Faz o cashing dos elementos
		this.comparisons++;
		if(this.camp == 0){	//Testa qual o campo a ser comparado
			if(A.getCamp1().compareTo(B.getCamp1()) >= 0){	//Compara os dados pela ordem alfanumerica
				return true;
			}
		}
		else{
			if(A.getCamp2().compareTo(B.getCamp2()) >= 0){
				return true;
			}	
		}
		return false;
	}
		
}
