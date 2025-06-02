// Algorithm: 0/1 Knapsack Problem
// Type: Dynamic Programming
// Time: O(n * W)
// Space: O(n * W)

#include <stdio.h>

int knapsack(int W, int wt[], int val[], int n) {
    int dp[n + 1][W + 1];

    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            if (i == 0 || w == 0)
                dp[i][w] = 0;
            else if (wt[i - 1] <= w)
                dp[i][w] = val[i - 1] + dp[i - 1][w - wt[i - 1]] > dp[i - 1][w]
                            ? val[i - 1] + dp[i - 1][w - wt[i - 1]]
                            : dp[i - 1][w];
            else
                dp[i][w] = dp[i - 1][w];
        }
    }

    return dp[n][W];
}
