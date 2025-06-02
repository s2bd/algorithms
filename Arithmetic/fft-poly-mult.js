// Algorithm: Fast Fourier Transform (for Polynomial Multiplication)
// Type: Divide and Conquer, Computational Algebra
// Time Complexity: O(n log n)
// Space Complexity: O(n)

const Complex = require('complex.js');

function fft(a) {
    const n = a.length;
    if (n === 1) return [a[0]];

    const w_n = new Complex({ re: Math.cos(2 * Math.PI / n), im: Math.sin(2 * Math.PI / n) });
    let w = new Complex(1, 0);
    const a_even = fft(a.filter((_, i) => i % 2 === 0));
    const a_odd = fft(a.filter((_, i) => i % 2 === 1));
    const y = Array(n);

    for (let k = 0; k < n / 2; k++) {
        const t = w.mul(a_odd[k]);
        y[k] = a_even[k].add(t);
        y[k + n/2] = a_even[k].sub(t);
        w = w.mul(w_n);
    }
    return y;
}
