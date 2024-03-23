package Metodos_de_Ordenamiento;

class RadixSort {
    static void radixSort(LinkedList list) {
        if (list.head == null || list.head.next == null)
            return;

        int max = getMaxValue(list);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(list, exp);
    }

    static void countSort(LinkedList list, int exp) {
        LinkedList.Node output = null;
        LinkedList.Node temp = null;
        int[] count = new int[10];

        LinkedList.Node current = list.head;
        while (current != null) {
            count[(current.data / exp) % 10]++;
            current = current.next;
        }

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        current = list.head;
        while (current != null) {
            temp = current.next;
            current.next = null;
            current.next = output;
            output = current;
            current = temp;
        }

        for (int i = list.head.data - 1; i >= 0; i--) {
            temp = output;
            output = output.next;

            int index = (temp.data / exp) % 10;
            LinkedList.Node currentCount = list.head;
            for (int j = 0; j < count[index] - 1; j++)
                currentCount = currentCount.next;

            temp.next = currentCount.next;
            currentCount.next = temp;
        }
    }

    static int getMaxValue(LinkedList list) {
        int max = Integer.MIN_VALUE;
        LinkedList.Node current = list.head;
        while (current != null) {
            if (current.data > max)
                max = current.data;
            current = current.next;
        }
        return max;
    }
}
