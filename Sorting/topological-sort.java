// Topological Sort
// Type: DAG, DFS-based
// Time: O(V + E)
// Space: O(V)

import java.util.*;

public class TopoSort {
    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited, stack, graph);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private static void dfs(int node, Set<Integer> visited, Stack<Integer> stack, Map<Integer, List<Integer>> graph) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) dfs(neighbor, visited, stack, graph);
        }
        stack.push(node);
    }
}
