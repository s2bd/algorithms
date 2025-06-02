// Kruskal's Algorithm
// Time: O(E log E)
// Space: O(V)

#include <stdio.h>
#include <stdlib.h>

typedef struct Edge {
    int src, dest, weight;
} Edge;

typedef struct Subset {
    int parent;
    int rank;
} Subset;

int compare(const void* a, const void* b) {
    Edge* e1 = (Edge*)a;
    Edge* e2 = (Edge*)b;
    return e1->weight - e2->weight;
}

int find(Subset subsets[], int i) {
    if (subsets[i].parent != i)
        subsets[i].parent = find(subsets, subsets[i].parent);
    return subsets[i].parent;
}

void unionSets(Subset subsets[], int x, int y) {
    int rootX = find(subsets, x);
    int rootY = find(subsets, y);

    if (subsets[rootX].rank < subsets[rootY].rank)
        subsets[rootX].parent = rootY;
    else if (subsets[rootY].rank < subsets[rootX].rank)
        subsets[rootY].parent = rootX;
    else {
        subsets[rootY].parent = rootX;
        subsets[rootX].rank++;
    }
}

void kruskal(Edge edges[], int E, int V) {
    qsort(edges, E, sizeof(Edge), compare);

    Subset *subsets = malloc(V * sizeof(Subset));
    for (int v = 0; v < V; v++) {
        subsets[v].parent = v;
        subsets[v].rank = 0;
    }

    Edge result[V];
    int e = 0; // Count edges in MST
    int i = 0; // Index for sorted edges

    while (e < V - 1 && i < E) {
        Edge next = edges[i++];
        int x = find(subsets, next.src);
        int y = find(subsets, next.dest);

        if (x != y) {
            result[e++] = next;
            unionSets(subsets, x, y);
        }
    }

    for (int i = 0; i < e; i++)
        printf("Edge %d-%d weight %d\n", result[i].src, result[i].dest, result[i].weight);

    free(subsets);
}
