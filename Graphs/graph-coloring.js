// Algorithm: Graph Coloring (M-Coloring)
// Type: Backtracking
// Time: O(M^V)
// Space: O(V)

function graphColoring(graph, m) {
    const V = graph.length;
    const colors = new Array(V).fill(0);

    function isSafe(v, c) {
        for (let i = 0; i < V; i++)
            if (graph[v][i] && colors[i] === c)
                return false;
        return true;
    }

    function solve(v) {
        if (v === V) return true;
        for (let c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;
                if (solve(v + 1)) return true;
                colors[v] = 0;
            }
        }
        return false;
    }

    if (solve(0)) {
        console.log("Solution exists:", colors);
    } else {
        console.log("No solution");
    }
}

// Example:
// const graph = [
//   [0, 1, 1, 1],
//   [1, 0, 1, 0],
//   [1, 1, 0, 1],
//   [1, 0, 1, 0]
// ];
// graphColoring(graph, 3);
