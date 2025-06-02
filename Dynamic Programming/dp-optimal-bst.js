// Algorithm: Optimal Binary Search Tree
// Type: Dynamic Programming
// Time: O(n^3)
// Space: O(n^2)

function optimalBST(freq) {
    const n = freq.length;
    const dp = Array.from({ length: n }, () => Array(n).fill(0));

    for (let i = 0; i < n; i++) dp[i][i] = freq[i];

    for (let L = 2; L <= n; L++) {
        for (let i = 0; i <= n - L; i++) {
            let j = i + L - 1;
            dp[i][j] = Infinity;
            const total = freq.slice(i, j + 1).reduce((a, b) => a + b, 0);

            for (let r = i; r <= j; r++) {
                const cost = (r > i ? dp[i][r - 1] : 0) +
                             (r < j ? dp[r + 1][j] : 0) + total;
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
    }

    return dp[0][n - 1];
}
