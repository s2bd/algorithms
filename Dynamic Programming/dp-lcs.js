// Algorithm: Longest Common Subsequence (LCS)
// Type: Dynamic Programming
// Time: O(m * n)
// Space: O(m * n)

function lcs(X, Y) {
    const m = X.length, n = Y.length;
    const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (X[i - 1] === Y[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    return dp[m][n];
}
