// Topological Sort (Kahn's Algorithm)
// Type: DAG, BFS-based
// Time: O(V + E)
// Space: O(V + E)

function kahnTopologicalSort(graph) {
    const indegree = {};
    const result = [];

    // Initialize indegrees
    for (const node in graph) {
        if (!(node in indegree)) indegree[node] = 0;
        for (const neighbor of graph[node]) {
            indegree[neighbor] = (indegree[neighbor] || 0) + 1;
        }
    }

    const queue = [];
    for (const node in graph) {
        if (indegree[node] === 0) queue.push(node);
    }

    while (queue.length > 0) {
        const u = queue.shift();
        result.push(u);

        for (const v of graph[u]) {
            indegree[v]--;
            if (indegree[v] === 0) queue.push(v);
        }
    }

    if (result.length === Object.keys(graph).length) {
        return result;
    } else {
        return "Cycle detected";
    }
}
