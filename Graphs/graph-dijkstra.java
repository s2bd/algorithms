// Dijkstra's Algorithm
// Time: O((V + E) log V)
// Space: O(V)

import java.util.*;

public class Dijkstra {
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            if (currentDist > dist.get(node)) continue;

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;
                if (newDist < dist.get(nextNode)) {
                    dist.put(nextNode, newDist);
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }
        return dist;
    }
}
