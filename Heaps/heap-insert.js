// Algorithm: Heap Insert
// Type: Heap, Insertion
// Time Complexity: O(log n)
// Space Complexity: O(1)

function heapInsert(arr, value) {
    arr.push(value);
    let i = arr.length - 1;
    let parent = Math.floor((i - 1) / 2);

    while (i > 0 && arr[parent] < arr[i]) {
        [arr[i], arr[parent]] = [arr[parent], arr[i]];
        i = parent;
        parent = Math.floor((i - 1) / 2);
    }
}
