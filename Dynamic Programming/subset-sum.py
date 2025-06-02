# Algorithm: Subset Sum
# Type: Dynamic Programming
# Time: O(n * sum)
# Space: O(n * sum)

def subset_sum(arr, target):
    n = len(arr)
    dp = [[False] * (target + 1) for _ in range(n + 1)]

    for i in range(n + 1):
        dp[i][0] = True  # sum 0 is possible with empty subset

    for i in range(1, n + 1):
        for s in range(1, target + 1):
            if arr[i - 1] > s:
                dp[i][s] = dp[i - 1][s]
            else:
                dp[i][s] = dp[i - 1][s] or dp[i - 1][s - arr[i - 1]]

    return dp[n][target]
