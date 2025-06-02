// Algorithm: Fast Fourier Transform (for Polynomial Multiplication)
// Type: Divide and Conquer, Computational Algebra
// Time Complexity: O(n log n)
// Space Complexity: O(n)

// Pseudocode for FFT in C-like structure using complex numbers
// Requires a library or custom complex number handling

void fft(Complex *a, int n, int invert) {
    if (n == 1) return;

    Complex a_even[n/2], a_odd[n/2];
    for (int i = 0; i < n / 2; ++i) {
        a_even[i] = a[2*i];
        a_odd[i] = a[2*i+1];
    }

    fft(a_even, n/2, invert);
    fft(a_odd, n/2, invert);

    double angle = 2 * M_PI / n * (invert ? -1 : 1);
    Complex w = {1, 0}, wn = {cos(angle), sin(angle)};
    for (int i = 0; i < n / 2; ++i) {
        Complex t = multiply(w, a_odd[i]);
        a[i] = add(a_even[i], t);
        a[i + n/2] = subtract(a_even[i], t);
        w = multiply(w, wn);
    }

    if (invert)
        for (int i = 0; i < n; ++i)
            a[i] = divide_by_scalar(a[i], 2);
}

