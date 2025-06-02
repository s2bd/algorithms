# Algorithm: Fast Fourier Transform (for Polynomial Multiplication)
# Type: Divide and Conquer, Computational Algebra
# Time Complexity: O(n log n)
# Space Complexity: O(n)

import cmath

def fft(a):
    n = len(a)
    if n == 1:
        return a
    w_n = cmath.exp(2j * cmath.pi / n)
    w = 1
    a_even = fft(a[0::2])
    a_odd = fft(a[1::2])
    y = [0] * n
    for k in range(n // 2):
        t = w * a_odd[k]
        y[k] = a_even[k] + t
        y[k + n // 2] = a_even[k] - t
        w *= w_n
    return y

def ifft(a):
    n = len(a)
    a_conj = [x.conjugate() for x in a]
    y = fft(a_conj)
    return [x.conjugate() / n for x in y]

def polynomial_multiply(p, q):
    n = 1
    while n < len(p) + len(q) - 1:
        n *= 2
    p += [0] * (n - len(p))
    q += [0] * (n - len(q))
    fft_p = fft([complex(x) for x in p])
    fft_q = fft([complex(x) for x in q])
    fft_r = [fft_p[i] * fft_q[i] for i in range(n)]
    result = ifft(fft_r)
    return [round(r.real) for r in result]
