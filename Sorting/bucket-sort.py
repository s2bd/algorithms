# Algorithm: Bucket Sort
# Type: Sorting, Non-comparison based
# Time Complexity: O(n + k) average
# Space Complexity: O(n + k)

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = key

def bucket_sort(arr, bucket_count=10):
    if len(arr) == 0:
        return arr

    max_val = max(arr)
    min_val = min(arr)
    bucket_range = (max_val - min_val) / bucket_count
    buckets = [[] for _ in range(bucket_count)]

    for num in arr:
        index = int((num - min_val) / bucket_range)
        if index == bucket_count:  # edge case for max_val
            index -= 1
        buckets[index].append(num)

    for bucket in buckets:
        insertion_sort(bucket)

    return [num for bucket in buckets for num in bucket]
