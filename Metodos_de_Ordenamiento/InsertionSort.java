package Metodos_de_Ordenamiento;
//Esta clase tiene el método de Búsqueda Inserción 
class InsertionSort{
    static void insertionSort(LinkedList list){
        if (list.head == null || list.head.next == null)
            return;

        LinkedList.Node sorted = null;
        LinkedList.Node current = list.head;
        while (current != null) {
            LinkedList.Node next = current.next;
            if (sorted == null || sorted.data >= current.data) {
                current.next = sorted;
                sorted = current;
            } else {
                LinkedList.Node temp = sorted;
                while (temp.next != null && temp.next.data < current.data){
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        list.head = sorted;
    }
}