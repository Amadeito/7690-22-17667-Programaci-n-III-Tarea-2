package Metodos_de_Ordenamiento;
//Esta clase contiene el método de conteo
class CountingSort{
    static void countingSort(LinkedList list){
        if (list.head == null || list.head.next == null)
            return;

        int max = getMaxValue(list);
        int min = getMinValue(list);

        int range = max - min + 1;
        int[] count = new int[range];
        LinkedList.Node current = list.head;
        LinkedList.Node temp = null;

        while (current != null) {
            count[current.data - min]++;
            current = current.next;
        }

        int j = 0;
        for (int i = min; i <= max; i++){
            while (count[i - min] > 0) {
                temp = list.head;
                temp.data = i;
                list.head = temp;
                count[i - min]--;
                j++;
                temp = temp.next;
            }
        }
    }

    static int getMaxValue(LinkedList list){
        int max = Integer.MIN_VALUE;
        LinkedList.Node current = list.head;
        while (current != null) {
            if (current.data > max)
                max = current.data;
            current = current.next;
        }
        return max;
    }

    static int getMinValue(LinkedList list){
        int min = Integer.MAX_VALUE;
        LinkedList.Node current = list.head;
        while (current != null) {
            if (current.data < min)
                min = current.data;
            current = current.next;
        }
        return min;
    }
}