package Metodos_de_Ordenamiento;
//Esta clase contiene el método de Burbuja
class BubbleSort {
    static void bubbleSort(LinkedList list){
        LinkedList.Node last = null;
        boolean swapped;
        do{
            swapped = false;
            LinkedList.Node current = list.head;
            while (current != last){
                if (current.next != null && current.data > current.next.data){
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }
}