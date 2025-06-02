// Algorithm: Heap Insert
// Type: Heap, Insertion
// Time Complexity: O(log n)
// Space Complexity: O(1)

public static void heapInsert(int[] arr, int size, int value) {
    arr[size] = value;
    int i = size;
    int parent = (i - 1) / 2;

    while (i > 0 && arr[parent] < arr[i]) {
        int temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;

        i = parent;
        parent = (i - 1) / 2;
    }
}
