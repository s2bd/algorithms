// Algorithm: Matrix Chain Multiplication
// Type: Dynamic Programming
// Time: O(n^3)
// Space: O(n^2)

function matrixChainOrder(p) {
    const n = p.length - 1;
    const dp = Array.from({ length: n }, () => Array(n).fill(0));

    for (let l = 2; l <= n; l++) {
        for (let i = 0; i <= n - l; i++) {
            const j = i + l - 1;
            dp[i][j] = Infinity;
            for (let k = i; k < j; k++) {
                const cost = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
    }

    return dp[0][n - 1];
}
