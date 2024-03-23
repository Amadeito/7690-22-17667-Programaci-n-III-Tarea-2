package Metodos_de_Ordenamiento;
//Esta clase contiene el método de Busqueda por montón
class HeapSort {
    static void heapSort(LinkedList list){
        if (list.head == null || list.head.next == null)
            return;

        int n = 0;
        LinkedList.Node current = list.head;
        while (current != null) {
            n++;
            current = current.next;
        }

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);

        for (int i = n - 1; i >= 0; i--) {
            LinkedList.Node temp = getNodeAtIndex(list.head, i);
            LinkedList.Node head = getNodeAtIndex(list.head, 0);

            temp.data = head.data;
            head.data = getNodeAtIndex(list.head, i).data;

            heapify(list, i, 0);
        }
    }

    static LinkedList.Node getNodeAtIndex(LinkedList.Node head, int index){
        LinkedList.Node current = head;
        for (int i = 0; i < index && current != null; i++)
            current = current.next;
        return current;
    }

    static void heapify(LinkedList list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        LinkedList.Node leftNode = getNodeAtIndex(list.head, left);
        LinkedList.Node rightNode = getNodeAtIndex(list.head, right);
        LinkedList.Node largestNode = getNodeAtIndex(list.head, largest);

        if (left < n && leftNode.data > largestNode.data)
            largest = left;

        if (right < n && rightNode.data > getNodeAtIndex(list.head, largest).data)
            largest = right;

        if (largest != i) {
            LinkedList.Node swapNode = getNodeAtIndex(list.head, i);
            LinkedList.Node largestSwap = getNodeAtIndex(list.head, largest);

            int temp = swapNode.data;
            swapNode.data = largestSwap.data;
            largestSwap.data = temp;

            heapify(list, n, largest);
        }
    }
}