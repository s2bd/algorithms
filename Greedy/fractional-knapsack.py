# Algorithm: Fractional Knapsack Problem
# Type: Greedy Algorithm
# Time: O(n log n)
# Space: O(n)

def fractional_knapsack(values, weights, capacity):
    items = sorted(
        [(v / w, v, w) for v, w in zip(values, weights)],
        key=lambda x: x[0],
        reverse=True
    )

    total_value = 0
    for ratio, value, weight in items:
        if capacity >= weight:
            total_value += value
            capacity -= weight
        else:
            total_value += ratio * capacity
            break

    return total_value
