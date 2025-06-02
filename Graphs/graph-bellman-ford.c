// Bellman-Ford Algorithm
// Time: O(V * E)
// Space: O(V)

#include <stdio.h>
#include <limits.h>

#define V 5
#define E 8

typedef struct Edge {
    int src, dest, weight;
} Edge;

int bellmanFord(Edge edges[], int V, int E, int start, int dist[]) {
    for (int i = 0; i < V; i++) dist[i] = INT_MAX;
    dist[start] = 0;

    for (int i = 1; i <= V - 1; i++) {
        for (int j = 0; j < E; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;
            if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    for (int j = 0; j < E; j++) {
        int u = edges[j].src;
        int v = edges[j].dest;
        int w = edges[j].weight;
        if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
            return 0; // Negative cycle detected
        }
    }
    return 1; // No negative cycle
}
