// Algorithm: Bucket Sort
// Type: Sorting, Non-comparison based
// Time Complexity: O(n + k) average
// Space Complexity: O(n + k)

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        float maxVal = arr[0], minVal = arr[0];
        for (float v : arr) {
            if (v > maxVal) maxVal = v;
            if (v < minVal) minVal = v;
        }

        int bucketCount = 10;
        float bucketRange = (maxVal - minVal) / bucketCount;
        ArrayList<Float>[] buckets = new ArrayList[bucketCount];

        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (float num : arr) {
            int index = (int)((num - minVal) / bucketRange);
            if (index == bucketCount) index--;
            buckets[index].add(num);
        }

        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        int idx = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[idx++] = num;
            }
        }
    }
}
