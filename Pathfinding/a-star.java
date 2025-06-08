// Algorithm: A* Search
// Type: Graph, Pathfinding, Heuristic-based Search
// Time Complexity: O(E)
// Space Complexity: O(V)

import java.util.*;

public class AStar {
    static class Node {
        String name;
        double f, g;

        Node(String name, double g, double f) {
            this.name = name; this.g = g; this.f = f;
        }
    }

    public static List<String> aStar(Map<String, List<Map.Entry<String, Integer>>> graph,
                                     String start, String goal,
                                     Map<String, Integer> heuristic) {
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingDouble(n -> n.f));
        Map<String, String> cameFrom = new HashMap<>();
        Map<String, Double> gScore = new HashMap<>();

        open.add(new Node(start, 0, heuristic.get(start)));
        gScore.put(start, 0.0);

        while (!open.isEmpty()) {
            Node current = open.poll();

            if (current.name.equals(goal)) {
                LinkedList<String> path = new LinkedList<>();
                while (cameFrom.containsKey(current.name)) {
                    path.addFirst(current.name);
                    current.name = cameFrom.get(current.name);
                }
                path.addFirst(start);
                return path;
            }

            for (Map.Entry<String, Integer> neighbor : graph.get(current.name)) {
                double tentative_g = gScore.get(current.name) + neighbor.getValue();
                if (tentative_g < gScore.getOrDefault(neighbor.getKey(), Double.MAX_VALUE)) {
                    cameFrom.put(neighbor.getKey(), current.name);
                    gScore.put(neighbor.getKey(), tentative_g);
                    double f = tentative_g + heuristic.get(neighbor.getKey());
                    open.add(new Node(neighbor.getKey(), tentative_g, f));
                }
            }
        }
        return null;
    }
}
