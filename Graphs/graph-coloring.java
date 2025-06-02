// Algorithm: Graph Coloring (M-Coloring)
// Type: Backtracking
// Time: O(M^V)
// Space: O(V)

public class GraphColoring {
    static int V = 4;
    static int[][] graph = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };
    static int[] colors = new int[V];

    static boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && colors[i] == c)
                return false;
        return true;
    }

    static boolean solve(int v, int m) {
        if (v == V) return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;
                if (solve(v + 1, m)) return true;
                colors[v] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int m = 3;
        if (solve(0, m)) {
            for (int c : colors) System.out.print(c + " ");
        } else {
            System.out.println("No solution");
        }
    }
}
