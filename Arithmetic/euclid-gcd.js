// Algorithm: Euclidean Algorithm for GCD
// Type: Number Theory
// Time: O(log(min(a, b)))
// Space: O(1)

function gcd(a, b) {
    while (b !== 0) {
        [a, b] = [b, a % b];
    }
    return a;
}

// Example: console.log(gcd(48, 18)); // Output: 6
