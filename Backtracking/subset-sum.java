// Algorithm: Subset Sum (Backtracking)
// Type: Backtracking / Recursive
// Time: O(2^n)
// Space: O(n)

import java.util.ArrayList;

public class SubsetSumBacktrack {
    public static void subsetSumBacktrack(int[] arr, int target, int index, ArrayList<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        if (target < 0 || index == arr.length)
            return;

        // Include arr[index]
        current.add(arr[index]);
        subsetSumBacktrack(arr, target - arr[index], index + 1, current);

        // Exclude arr[index]
        current.remove(current.size() - 1);
        subsetSumBacktrack(arr, target, index + 1, current);
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        subsetSumBacktrack(arr, 9, 0, new ArrayList<>());
    }
}
