// Algorithm: Extended Euclidean Algorithm
// Type: Number Theory
// Time: O(log(min(a, b)))
// Space: O(log(min(a, b)))

#include <stdio.h>

int extendedGCD(int a, int b, int* x, int* y) {
    if (b == 0) {
        *x = 1;
        *y = 0;
        return a;
    }
    int x1, y1;
    int gcd = extendedGCD(b, a % b, &x1, &y1);
    *x = y1;
    *y = x1 - (a / b) * y1;
    return gcd;
}

// Example:
// int main() {
//     int x, y;
//     int g = extendedGCD(30, 20, &x, &y);
//     printf("GCD: %d, x: %d, y: %d\n", g, x, y); // Output: GCD: 10, x: 1, y: -1
//     return 0;
// }
