// Algorithm: Bucket Sort
// Type: Sorting, Non-comparison based
// Time Complexity: O(n + k) average
// Space Complexity: O(n + k)

#include <stdio.h>
#include <stdlib.h>

void insertionSort(float arr[], int n) {
    for (int i = 1; i < n; i++) {
        float key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

void bucketSort(float arr[], int n) {
    int bucketCount = 10;
    float maxVal = arr[0], minVal = arr[0];

    for (int i = 1; i < n; i++) {
        if (arr[i] > maxVal) maxVal = arr[i];
        if (arr[i] < minVal) minVal = arr[i];
    }

    float bucketRange = (maxVal - minVal) / bucketCount;

    // Create buckets (array of float pointers)
    float* buckets[bucketCount];
    int bucketSizes[bucketCount];
    for (int i = 0; i < bucketCount; i++) {
        buckets[i] = (float*)malloc(n * sizeof(float)); // max size n for simplicity
        bucketSizes[i] = 0;
    }

    for (int i = 0; i < n; i++) {
        int index = (int)((arr[i] - minVal) / bucketRange);
        if (index == bucketCount) index--;
        buckets[index][bucketSizes[index]++] = arr[i];
    }

    for (int i = 0; i < bucketCount; i++) {
        insertionSort(buckets[i], bucketSizes[i]);
    }

    int idx = 0;
    for (int i = 0; i < bucketCount; i++) {
        for (int j = 0; j < bucketSizes[i]; j++) {
            arr[idx++] = buckets[i][j];
        }
        free(buckets[i]);
    }
}
