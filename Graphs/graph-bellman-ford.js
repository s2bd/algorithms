// Bellman-Ford Algorithm
// Time: O(V * E)
// Space: O(V)

function bellmanFord(edges, V, start) {
    const dist = Array(V).fill(Infinity);
    dist[start] = 0;

    for (let i = 1; i <= V - 1; i++) {
        for (const [u, v, w] of edges) {
            if (dist[u] !== Infinity && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    // Check for negative-weight cycles
    for (const [u, v, w] of edges) {
        if (dist[u] !== Infinity && dist[u] + w < dist[v]) {
            throw new Error("Graph contains negative weight cycle");
        }
    }

    return dist;
}
