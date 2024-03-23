package Metodos_de_Ordenamiento;

import java.util.Scanner;

public class MenuMetodosOrdenamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// Crear lista enlazada
		LinkedList list = new LinkedList();
		
		//Insertar los elementos de la lista
		list.insert(5);
		list.insert(3);
		list.insert(8);
		list.insert(1);
		list.insert(9);
		
		//Switch para el menú de opciones
		System.out.println("Seleccione el método de ordenamiento que desea utilizar: ");
		System.out.println("1. Selection sort (selección)");
		System.out.println("2. Bubble sort (burbuja)");
		System.out.println("3. Insertion sort (inserción)");
		System.out.println("4. Merge sort (combinación)");
		System.out.println("5. Quick sort (rápida)");
		System.out.println("6. Heap sort (montón)");
		System.out.println("7. Counting sort (conteo)");
		System.out.println("8. Radix sort (raíz)");
		System.out.println("9. Bucket sort (cubo)");
        
        int choice = scanner.nextInt();
        
        switch(choice){
        	case 1:
        		SelectionSort.selectionSort(list);
        		break;
        	case 2:
        		BubbleSort.bubbleSort(list);
        		break;
        	case 3:
        		InsertionSort.insertionSort(list);
        		break;
        	case 4:
        		MergeSort.mergeSort(list);
        		break;
        	case 5:
        		QuickSort.quickSort(list);
        		break;
        	case 6:
        		HeapSort.heapSort(list);
        		break;
        	case 7:
        		CountingSort.countingSort(list);
        		break;
        	case 8:
        		RadixSort.radixSort(list);
        		break;
        	case 9:
        		BucketSort.bucketSort(list);
        		break;
        	default:
        		System.out.println("Opcion inválida");
        	
        }
        //Se imprime la lista ordenada
        System.out.println("Lista ordenada: ");
        list.display();
        
        scanner.close();
     
	}

}
