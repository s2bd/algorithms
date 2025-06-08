// Algorithm: A* Search
// Type: Graph, Pathfinding, Heuristic-based Search
// Time Complexity: O(E)
// Space Complexity: O(V)

function aStar(start, goal, graph, heuristic) {
    const openSet = [[0, start]];
    const cameFrom = {};
    const gScore = { [start]: 0 };
    const fScore = { [start]: heuristic(start, goal) };

    while (openSet.length > 0) {
        openSet.sort((a, b) => a[0] - b[0]);
        const [_, current] = openSet.shift();

        if (current === goal) {
            const path = [];
            let node = current;
            while (cameFrom[node]) {
                path.unshift(node);
                node = cameFrom[node];
            }
            return [start, ...path];
        }

        for (const [neighbor, cost] of graph[current]) {
            const tentative_g = gScore[current] + cost;
            if (!(neighbor in gScore) || tentative_g < gScore[neighbor]) {
                cameFrom[neighbor] = current;
                gScore[neighbor] = tentative_g;
                fScore[neighbor] = tentative_g + heuristic(neighbor, goal);
                openSet.push([fScore[neighbor], neighbor]);
            }
        }
    }

    return null;
}
