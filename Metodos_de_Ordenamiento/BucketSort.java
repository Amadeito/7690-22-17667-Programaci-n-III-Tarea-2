package Metodos_de_Ordenamiento;
//Esta clase contiene el método de Cubo
class BucketSort {
    static void bucketSort(LinkedList list) {
        if (list.head == null || list.head.next == null)
            return;

        // Find maximum value in the list
        int maxValue = getMaxValue(list);

        // Create buckets
        LinkedList[] buckets = new LinkedList[maxValue + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList();
        }

        // Put elements into buckets
        LinkedList.Node current = list.head;
        while (current != null) {
            buckets[current.data].insert(current.data);
            current = current.next;
        }

        // Merge buckets back into original list
        list.head = mergeBuckets(buckets);
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

    static LinkedList.Node mergeBuckets(LinkedList[] buckets) {
        LinkedList mergedList = new LinkedList();
        for (LinkedList bucket : buckets) {
            mergedList.merge(bucket);
        }
        return mergedList.head;
    }
}
