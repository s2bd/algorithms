// Algorithm: Matrix Chain Multiplication
// Type: Dynamic Programming
// Time: O(n^3)
// Space: O(n^2)

public class MatrixChain {
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] dp = new int[n][n];

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}
