// Algorithm: Activity Selection
// Type: Greedy
// Time: O(n log n)
// Space: O(1)

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int start, end;
} Activity;

int compare(const void* a, const void* b) {
    return ((Activity*)a)->end - ((Activity*)b)->end;
}

void activitySelection(Activity arr[], int n) {
    qsort(arr, n, sizeof(Activity), compare);

    printf("Selected Activities:\n");
    printf("(%d, %d)\n", arr[0].start, arr[0].end);
    int last_end = arr[0].end;

    for (int i = 1; i < n; i++) {
        if (arr[i].start >= last_end) {
            printf("(%d, %d)\n", arr[i].start, arr[i].end);
            last_end = arr[i].end;
        }
    }
}
