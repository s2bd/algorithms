// Algorithm: Subset Sum (Backtracking)
// Type: Backtracking / Recursive
// Time: O(2^n)
// Space: O(n)

#include <stdio.h>

void printSubset(int subset[], int size) {
    printf("{ ");
    for (int i = 0; i < size; i++)
        printf("%d ", subset[i]);
    printf("}\n");
}

void subsetSumBacktrack(int arr[], int n, int target, int index, int subset[], int subsetSize) {
    if (target == 0) {
        printSubset(subset, subsetSize);
        return;
    }
    if (target < 0 || index == n)
        return;

    // Include arr[index]
    subset[subsetSize] = arr[index];
    subsetSumBacktrack(arr, n, target - arr[index], index + 1, subset, subsetSize + 1);

    // Exclude arr[index]
    subsetSumBacktrack(arr, n, target, index + 1, subset, subsetSize);
}

// Usage:
// int arr[] = {3, 34, 4, 12, 5, 2};
// int subset[6];
// subsetSumBacktrack(arr, 6, 9, 0, subset, 0);
