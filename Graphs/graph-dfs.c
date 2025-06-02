// DFS - Graph traversal
// Time: O(V + E)
// Space: O(V)

#include <stdio.h>
#include <stdbool.h>

#define MAX_VERTICES 100

int graph[MAX_VERTICES][MAX_VERTICES]; // adjacency matrix
bool visited[MAX_VERTICES];
int V; // number of vertices

void dfs(int node) {
    visited[node] = true;
    printf("%d ", node);
    for (int i = 0; i < V; i++) {
        if (graph[node][i] && !visited[i]) {
            dfs(i);
        }
    }
}
