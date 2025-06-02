// Prim's Algorithm
// Time: O(E log V)
// Space: O(V + E)

import java.util.*;

public class Prim {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) { dest = d; weight = w; }
    }

    public static List<int[]> prim(List<List<Edge>> graph, int start) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        List<int[]> MST = new ArrayList<>();

        pq.add(new int[]{start, 0, -1}); // vertex, weight, parent

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1], parent = curr[2];
            if (visited[u]) continue;
            visited[u] = true;

            if (parent != -1) MST.add(new int[]{parent, u, w});

            for (Edge e : graph.get(u)) {
                if (!visited[e.dest]) {
                    pq.add(new int[]{e.dest, e.weight, u});
                }
            }
        }
        return MST;
    }
}
