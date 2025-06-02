# Algorithm: Subset Sum (Backtracking)
# Type: Backtracking / Recursive
# Time: O(2^n)
# Space: O(n)

def subset_sum_backtrack(arr, target, index=0, current=[]):
    if target == 0:
        print(current)
        return
    if target < 0 or index == len(arr):
        return

    # Include arr[index]
    subset_sum_backtrack(arr, target - arr[index], index + 1, current + [arr[index]])
    # Exclude arr[index]
    subset_sum_backtrack(arr, target, index + 1, current)

# Example usage:
# subset_sum_backtrack([3, 34, 4, 12, 5, 2], 9)
