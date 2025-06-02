# Topological Sort (Kahn's Algorithm)
# Type: DAG, BFS-based
# Time: O(V + E)
# Space: O(V + E)

from collections import deque, defaultdict

def kahn_topological_sort(graph):
    indegree = defaultdict(int)
    for u in graph:
        for v in graph[u]:
            indegree[v] += 1

    queue = deque([u for u in graph if indegree[u] == 0])
    result = []

    while queue:
        u = queue.popleft()
        result.append(u)
        for v in graph.get(u, []):
            indegree[v] -= 1
            if indegree[v] == 0:
                queue.append(v)

    if len(result) == len(graph):
        return result
    else:
        return "Cycle detected"
