// Algorithm: PageRank
// Type: Graph, Ranking, Link Analysis
// Time Complexity: O(k * (V + E))
// Space Complexity: O(V)

function pageRank(graph, d = 0.85, maxIter = 100) {
    const nodes = Object.keys(graph);
    const N = nodes.length;
    let rank = {};
    nodes.forEach(node => rank[node] = 1 / N);

    for (let iter = 0; iter < maxIter; iter++) {
        let newRank = {};
        nodes.forEach(node => newRank[node] = (1 - d) / N);

        nodes.forEach(node => {
            const neighbors = graph[node];
            if (neighbors.length > 0) {
                let share = rank[node] / neighbors.length;
                neighbors.forEach(neighbor => {
                    newRank[neighbor] += d * share;
                });
            }
        });

        rank = newRank;
    }

    return rank;
}
