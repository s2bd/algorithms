// Algorithm: Euclidean Algorithm for GCD
// Type: Number Theory
// Time: O(log(min(a, b)))
// Space: O(1)

public class GCD {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // Output: 6
    }
}
