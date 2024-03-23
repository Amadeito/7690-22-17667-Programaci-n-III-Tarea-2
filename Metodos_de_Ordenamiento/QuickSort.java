package Metodos_de_Ordenamiento;
//Esta clase contiene el método de búsqueda rápida
class QuickSort{
    static void quickSort(LinkedList list){
        if (list.head == null || list.head.next == null)
            return;

        list.head = quickSortRecursive(list.head);
    }

    static LinkedList.Node quickSortRecursive(LinkedList.Node head){
        if (head == null || head.next == null)
            return head;

        LinkedList.Node pivot = partition(head);
        LinkedList.Node left = quickSortRecursive(head);
        LinkedList.Node right = quickSortRecursive(pivot.next);

        pivot.next = right;
        if (left == null)
            return pivot;

        LinkedList.Node tail = left;
        while (tail.next != null)
            tail = tail.next;

        tail.next = pivot;
        return left;
    }

    static LinkedList.Node partition(LinkedList.Node head){
        LinkedList.Node slow = head, fast = head, prev = null;
        LinkedList.Node pivot = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }
}