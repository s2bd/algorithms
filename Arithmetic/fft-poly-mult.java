// Algorithm: Fast Fourier Transform (for Polynomial Multiplication)
// Type: Divide and Conquer, Computational Algebra
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Complex {
    double re, im;

    Complex(double real, double imag) {
        this.re = real;
        this.im = imag;
    }

    Complex add(Complex other) {
        return new Complex(this.re + other.re, this.im + other.im);
    }

    Complex sub(Complex other) {
        return new Complex(this.re - other.re, this.im - other.im);
    }

    Complex mul(Complex other) {
        double real = this.re * other.re - this.im * other.im;
        double imag = this.re * other.im + this.im * other.re;
        return new Complex(real, imag);
    }

    Complex div(double scalar) {
        return new Complex(this.re / scalar, this.im / scalar);
    }

    Complex conjugate() {
        return new Complex(this.re, -this.im);
    }

    public String toString() {
        return String.format("%.2f + %.2fi", re, im);
    }
}

public class FFT {
    public static Complex[] fft(Complex[] a, boolean invert) {
        int n = a.length;
        if (n == 1) return new Complex[]{a[0]};

        Complex[] a0 = new Complex[n / 2];
        Complex[] a1 = new Complex[n / 2];
        for (int i = 0; 2 * i < n; i++) {
            a0[i] = a[2 * i];
            a1[i] = a[2 * i + 1];
        }

        Complex[] y0 = fft(a0, invert);
        Complex[] y1 = fft(a1, invert);

        Complex[] y = new Complex[n];
        double ang = 2 * Math.PI / n * (invert ? -1 : 1);
        Complex w = new Complex(1, 0);
        Complex wn = new Complex(Math.cos(ang), Math.sin(ang));

        for (int i = 0; i < n / 2; i++) {
            Complex t = w.mul(y1[i]);
            y[i] = y0[i].add(t);
            y[i + n / 2] = y0[i].sub(t);
            if (invert) {
                y[i] = y[i].div(2);
                y[i + n / 2] = y[i + n / 2].div(2);
            }
            w = w.mul(wn);
        }
        return y;
    }

    public static void main(String[] args) {
        // Example usage:
        Complex[] poly = {
            new Complex(1, 0),
            new Complex(2, 0),
            new Complex(3, 0),
            new Complex(0, 0)
        };

        Complex[] result = fft(poly, false);
        for (Complex c : result)
            System.out.println(c);
    }
}
