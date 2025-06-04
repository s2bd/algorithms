# Algorithm: Selection Sort
# Type: Sorting (Comparison-based)
# Time Complexity: O(n^2)
# Space Complexity: O(1)

def selection_sort(arr):
    n = len(arr)
    for i in range(n):
        min_idx = i
        for j in range(i + 1, n):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
