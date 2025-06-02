// Algorithm: Bubble Sort
// Type: Sorting, Comparison based
// Time Complexity: O(n^2)
// Space Complexity: O(1)

function bubbleSort(arr) {
    const n = arr.length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }
}
