// Topological Sort (Kahn's Algorithm)
// Type: DAG, BFS-based
// Time: O(V + E)
// Space: O(V + E)

import java.util.*;

public class KahnTopoSort {
    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int u : graph.keySet())
            for (int v : graph.get(u))
                indegree.put(v, indegree.getOrDefault(v, 0) + 1);

        Queue<Integer> queue = new LinkedList<>();
        for (int u : graph.keySet())
            if (!indegree.containsKey(u))
                queue.offer(u);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int v : graph.getOrDefault(u, new ArrayList<>())) {
                indegree.put(v, indegree.get(v) - 1);
                if (indegree.get(v) == 0)
                    queue.offer(v);
            }
        }

        if (result.size() != graph.size())
            throw new RuntimeException("Cycle detected");

        return result;
    }
}
