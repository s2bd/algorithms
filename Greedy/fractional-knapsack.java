// Algorithm: Fractional Knapsack Problem
// Type: Greedy Algorithm
// Time: O(n log n)
// Space: O(n)

import java.util.*;

class Item {
    int value, weight;
    double ratio;

    Item(int v, int w) {
        value = v;
        weight = w;
        ratio = (double) v / w;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++)
            items[i] = new Item(values[i], weights[i]);

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double total = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                total += item.value;
                capacity -= item.weight;
            } else {
                total += item.ratio * capacity;
                break;
            }
        }

        return total;
    }
}
