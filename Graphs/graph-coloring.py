# Algorithm: Graph Coloring (M-Coloring)
# Type: Backtracking
# Time: O(M^V)
# Space: O(V)

def graph_coloring(graph, m):
    n = len(graph)
    colors = [0] * n

    def is_safe(node, c):
        for neighbor in range(n):
            if graph[node][neighbor] == 1 and colors[neighbor] == c:
                return False
        return True

    def solve(node):
        if node == n:
            return True
        for c in range(1, m + 1):
            if is_safe(node, c):
                colors[node] = c
                if solve(node + 1):
                    return True
                colors[node] = 0
        return False

    if solve(0):
        print("Solution exists:", colors)
    else:
        print("No solution")
