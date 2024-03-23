package Metodos_de_Ordenamiento;
//Esta clase contiene el método de Combinación
class MergeSort{
    static void mergeSort(LinkedList list){
        if (list.head == null || list.head.next == null)
            return;

        list.head = mergeSortRecursive(list.head);
    }

    static LinkedList.Node mergeSortRecursive(LinkedList.Node head){
        if (head == null || head.next == null)
            return head;

        LinkedList.Node middle = getMiddle(head);
        LinkedList.Node nextOfMiddle = middle.next;
        middle.next = null;

        LinkedList.Node left = mergeSortRecursive(head);
        LinkedList.Node right = mergeSortRecursive(nextOfMiddle);

        return merge(left, right);
    }

    static LinkedList.Node merge(LinkedList.Node left, LinkedList.Node right){
        LinkedList.Node result = null;

        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    static LinkedList.Node getMiddle(LinkedList.Node head){
        if (head == null)
            return head;

        LinkedList.Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}