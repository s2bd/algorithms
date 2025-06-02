// Algorithm: Extended Euclidean Algorithm
// Type: Number Theory
// Time: O(log(min(a, b)))
// Space: O(log(min(a, b)))

function extendedGCD(a, b) {
    if (b === 0) return { gcd: a, x: 1, y: 0 };

    const result = extendedGCD(b, a % b);
    const x = result.y;
    const y = result.x - Math.floor(a / b) * result.y;

    return { gcd: result.gcd, x, y };
}

// Example:
// const res = extendedGCD(30, 20);
// console.log(res); // { gcd: 10, x: 1, y: -1 }
