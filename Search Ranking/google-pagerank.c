// Algorithm: PageRank
// Type: Graph, Ranking, Link Analysis
// Time Complexity: O(k * (V + E))
// Space Complexity: O(V)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NODES 100
#define DAMPING 0.85
#define MAX_ITER 100

void pagerank(int graph[MAX_NODES][MAX_NODES], int N, double rank[MAX_NODES]) {
    double new_rank[MAX_NODES];
    for (int i = 0; i < N; i++) rank[i] = 1.0 / N;

    for (int iter = 0; iter < MAX_ITER; iter++) {
        for (int i = 0; i < N; i++) new_rank[i] = (1 - DAMPING) / N;

        for (int u = 0; u < N; u++) {
            int out_deg = 0;
            for (int j = 0; j < N; j++) if (graph[u][j]) out_deg++;

            if (out_deg > 0) {
                for (int v = 0; v < N; v++) {
                    if (graph[u][v])
                        new_rank[v] += DAMPING * (rank[u] / out_deg);
                }
            }
        }
        memcpy(rank, new_rank, sizeof(double) * N);
    }
}
