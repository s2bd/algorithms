# Algorithm: Extended Euclidean Algorithm
# Type: Number Theory
# Time: O(log(min(a, b)))
# Space: O(log(min(a, b)))

def extended_gcd(a, b):
    if b == 0:
        return (a, 1, 0)
    gcd, x1, y1 = extended_gcd(b, a % b)
    x = y1
    y = x1 - (a // b) * y1
    return (gcd, x, y)

# Example: print(extended_gcd(30, 20))  # Output: (10, 1, -1)
