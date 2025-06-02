// Algorithm: Optimal Binary Search Tree
// Type: Dynamic Programming
// Time: O(n^3)
// Space: O(n^2)

public class OptimalBST {
    static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) s += freq[k];
        return s;
    }

    public static int optimalBST(int[] freq) {
        int n = freq.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = freq[i];

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int total = sum(freq, i, j);

                for (int r = i; r <= j; r++) {
                    int cost = (r > i ? dp[i][r - 1] : 0) +
                               (r < j ? dp[r + 1][j] : 0) + total;
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}
