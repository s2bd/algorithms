// Algorithm: Euclidean Algorithm for GCD
// Type: Number Theory
// Time: O(log(min(a, b)))
// Space: O(1)

#include <stdio.h>

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    printf("%d\n", gcd(48, 18)); // Output: 6
    return 0;
}
