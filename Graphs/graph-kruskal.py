# Kruskal's Algorithm
# Time: O(E log E)
# Space: O(V)

class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0]*n

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        rootU, rootV = self.find(u), self.find(v)
        if rootU != rootV:
            if self.rank[rootU] < self.rank[rootV]:
                self.parent[rootU] = rootV
            elif self.rank[rootV] < self.rank[rootU]:
                self.parent[rootV] = rootU
            else:
                self.parent[rootV] = rootU
                self.rank[rootU] += 1
            return True
        return False

def kruskal(edges, num_vertices):
    edges.sort(key=lambda x: x[2])  # Sort by weight
    uf = UnionFind(num_vertices)
    MST = []

    for u, v, w in edges:
        if uf.union(u, v):
            MST.append((u, v, w))

    return MST
