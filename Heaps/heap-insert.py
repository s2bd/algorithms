# Algorithm: Heap Insert
# Type: Heap, Insertion
# Time Complexity: O(log n)
# Space Complexity: O(1)

def heap_insert(arr, value):
    arr.append(value)
    i = len(arr) - 1
    parent = (i - 1) // 2
    while i > 0 and arr[parent] < arr[i]:
        arr[i], arr[parent] = arr[parent], arr[i]
        i = parent
        parent = (i - 1) // 2
