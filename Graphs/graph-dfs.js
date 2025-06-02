// DFS - Graph traversal
// Time: O(V + E)
// Space: O(V)

function dfs(graph, start, visited = new Set()) {
    visited.add(start);
    console.log(start); // or process node
    for (const neighbor of graph[start] || []) {
        if (!visited.has(neighbor)) {
            dfs(graph, neighbor, visited);
        }
    }
}
