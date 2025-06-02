# Algorithm: Optimal Binary Search Tree
# Type: Dynamic Programming
# Time: O(n^3)
# Space: O(n^2)

def optimal_bst(freq):
    n = len(freq)
    dp = [[0] * n for _ in range(n)]

    for i in range(n):
        dp[i][i] = freq[i]

    for L in range(2, n + 1):
        for i in range(n - L + 1):
            j = i + L - 1
            dp[i][j] = float('inf')
            total = sum(freq[i:j + 1])

            for r in range(i, j + 1):
                cost = (dp[i][r - 1] if r > i else 0) + \
                       (dp[r + 1][j] if r < j else 0) + total
                dp[i][j] = min(dp[i][j], cost)

    return dp[0][n - 1]
