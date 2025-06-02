// BFS - Graph traversal
// Time: O(V + E)
// Space: O(V)

function bfs(graph, start) {
    const visited = new Set([start]);
    const queue = [start];

    while (queue.length > 0) {
        const node = queue.shift();
        console.log(node); // or process node

        for (const neighbor of graph[node] || []) {
            if (!visited.has(neighbor)) {
                visited.add(neighbor);
                queue.push(neighbor);
            }
        }
    }
}
