# Prim's Algorithm
# Time: O(E log V)
# Space: O(V + E)
import heapq

def prim(graph, start=0):
    MST = []
    visited = set()
    min_heap = [(0, start, None)]  # (weight, vertex, parent)
    
    while min_heap:
        weight, u, parent = heapq.heappop(min_heap)
        if u in visited:
            continue
        visited.add(u)
        if parent is not None:
            MST.append((parent, u, weight))
        
        for v, w in graph[u]:
            if v not in visited:
                heapq.heappush(min_heap, (w, v, u))
    return MST
