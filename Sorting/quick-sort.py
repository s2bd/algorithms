# Algorithm: Quick Sort
# Type: Sorting, Divide and Conquer
# Time Complexity: O(n log n) average, O(n^2) worst
# Space Complexity: O(log n) auxiliary (recursive stack)

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[0]
    less = [x for x in arr[1:] if x <= pivot]
    greater = [x for x in arr[1:] if x > pivot]
    return quick_sort(less) + [pivot] + quick_sort(greater)
