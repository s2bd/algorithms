// Algorithm: PageRank
// Type: Graph, Ranking, Link Analysis
// Time Complexity: O(k * (V + E))
// Space Complexity: O(V)

import java.util.*;

public class PageRank {
    public static Map<String, Double> compute(Map<String, List<String>> graph, double d, int maxIter) {
        int N = graph.size();
        Map<String, Double> rank = new HashMap<>();
        for (String node : graph.keySet()) {
            rank.put(node, 1.0 / N);
        }

        for (int iter = 0; iter < maxIter; iter++) {
            Map<String, Double> newRank = new HashMap<>();
            for (String node : graph.keySet()) {
                newRank.put(node, (1 - d) / N);
            }

            for (String node : graph.keySet()) {
                List<String> outLinks = graph.get(node);
                if (!outLinks.isEmpty()) {
                    double share = rank.get(node) / outLinks.size();
                    for (String neighbor : outLinks) {
                        newRank.put(neighbor, newRank.get(neighbor) + d * share);
                    }
                }
            }
            rank = newRank;
        }

        return rank;
    }
}
