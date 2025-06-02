// Topological Sort (Kahn's Algorithm)
// Type: DAG, BFS-based
// Time: O(V + E)
// Space: O(V + E)

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int graph[MAX][MAX], indegree[MAX], V;

void kahnTopologicalSort() {
    int queue[MAX], front = 0, rear = 0, count = 0;
    int result[MAX];

    for (int i = 0; i < V; i++)
        if (indegree[i] == 0)
            queue[rear++] = i;

    while (front < rear) {
        int u = queue[front++];
        result[count++] = u;

        for (int v = 0; v < V; v++) {
            if (graph[u][v]) {
                indegree[v]--;
                if (indegree[v] == 0)
                    queue[rear++] = v;
            }
        }
    }

    if (count != V)
        printf("Cycle detected\n");
    else {
        for (int i = 0; i < V; i++)
            printf("%d ", result[i]);
        printf("\n");
    }
}
