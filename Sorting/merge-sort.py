# Algorithm: Merge Sort
# Type: Sorting, Divide and Conquer
# Time Complexity: O(n log n)
# Space Complexity: O(n)

def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(left, right):
    result = []
    while left and right:
        result.append((left if left[0] < right[0] else right).pop(0))
    return result + left + right

