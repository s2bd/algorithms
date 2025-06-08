# Algorithm: PageRank
# Type: Graph, Ranking, Link Analysis
# Time Complexity: O(k * (V + E))
# Space Complexity: O(V)

def pagerank(graph, d=0.85, max_iter=100):
    N = len(graph)
    rank = {node: 1 / N for node in graph}

    for _ in range(max_iter):
        new_rank = {node: (1 - d) / N for node in graph}
        for node in graph:
            neighbors = graph[node]
            if neighbors:
                share = rank[node] / len(neighbors)
                for neighbor in neighbors:
                    new_rank[neighbor] += d * share
        rank = new_rank

    return rank
