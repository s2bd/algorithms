// Algorithm: Subset Sum
// Type: Dynamic Programming
// Time: O(n * sum)
// Space: O(n * sum)

function subsetSum(arr, target) {
    const n = arr.length;
    const dp = Array.from({ length: n + 1 }, () => Array(target + 1).fill(false));

    for (let i = 0; i <= n; i++) dp[i][0] = true;

    for (let i = 1; i <= n; i++) {
        for (let s = 1; s <= target; s++) {
            if (arr[i - 1] > s) {
                dp[i][s] = dp[i - 1][s];
            } else {
                dp[i][s] = dp[i - 1][s] || dp[i - 1][s - arr[i - 1]];
            }
        }
    }

    return dp[n][target];
}
