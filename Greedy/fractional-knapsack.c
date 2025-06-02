// Algorithm: Fractional Knapsack Problem
// Type: Greedy Algorithm
// Time: O(n log n)
// Space: O(n)

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int value, weight;
    float ratio;
} Item;

int compare(const void *a, const void *b) {
    return ((Item *)b)->ratio > ((Item *)a)->ratio ? 1 : -1;
}

float fractionalKnapsack(int W, Item items[], int n) {
    for (int i = 0; i < n; i++)
        items[i].ratio = (float)items[i].value / items[i].weight;

    qsort(items, n, sizeof(Item), compare);

    float totalValue = 0.0;
    for (int i = 0; i < n && W > 0; i++) {
        if (items[i].weight <= W) {
            totalValue += items[i].value;
            W -= items[i].weight;
        } else {
            totalValue += items[i].ratio * W;
            break;
        }
    }

    return totalValue;
}
