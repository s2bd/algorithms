// Kruskal's Algorithm
// Time: O(E log E)
// Space: O(V)

import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int u) {
            if (parent[u] != u) parent[u] = find(parent[u]);
            return parent[u];
        }
        boolean union(int u, int v) {
            int rootU = find(u), rootV = find(v);
            if (rootU == rootV) return false;
            if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
            else if (rank[rootV] < rank[rootU]) parent[rootV] = rootU;
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }

    public static List<Edge> kruskal(List<Edge> edges, int V) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        List<Edge> MST = new ArrayList<>();

        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                MST.add(edge);
            }
        }
        return MST;
    }
}
