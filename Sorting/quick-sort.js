// Algorithm: Quick Sort
// Type: Sorting, Divide and Conquer
// Time Complexity: O(n log n) average, O(n^2) worst
// Space Complexity: O(log n)

function quickSort(arr) {
    if (arr.length <= 1) return arr;

    const pivot = arr[arr.length - 1];
    const left = [], right = [];

    for (let i = 0; i < arr.length - 1; i++) {
        if (arr[i] < pivot) left.push(arr[i]);
        else right.push(arr[i]);
    }

    return [...quickSort(left), pivot, ...quickSort(right)];
}
