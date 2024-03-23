package Metodos_de_Ordenamiento;
//Esta clase es para la busqueda por selección
class SelectionSort {
	static void selectionSort(LinkedList list) {
        LinkedList.Node current = list.head;
        while (current != null) {
            LinkedList.Node min = current;
            LinkedList.Node innerCurrent = current.next;
            while (innerCurrent != null) {
                if (innerCurrent.data < min.data) {
                    min = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            int temp = current.data;
            current.data = min.data;
            min.data = temp;
            current = current.next;
        }
    }

}
