// Algorithm: Subset Sum (Backtracking)
// Type: Backtracking / Recursive
// Time: O(2^n)
// Space: O(n)

function subsetSumBacktrack(arr, target, index = 0, current = []) {
    if (target === 0) {
        console.log(current);
        return;
    }
    if (target < 0 || index === arr.length) return;

    // Include arr[index]
    subsetSumBacktrack(arr, target - arr[index], index + 1, [...current, arr[index]]);
    // Exclude arr[index]
    subsetSumBacktrack(arr, target, index + 1, current);
}

// Example:
// subsetSumBacktrack([3, 34, 4, 12, 5, 2], 9);
