// Algorithm: Extended Euclidean Algorithm
// Type: Number Theory
// Time: O(log(min(a, b)))
// Space: O(log(min(a, b)))

public class ExtendedGCD {
    static class Result {
        int gcd, x, y;
        Result(int g, int x, int y) {
            this.gcd = g; this.x = x; this.y = y;
        }
    }

    static Result extendedGCD(int a, int b) {
        if (b == 0)
            return new Result(a, 1, 0);
        Result r = extendedGCD(b, a % b);
        int x = r.y;
        int y = r.x - (a / b) * r.y;
        return new Result(r.gcd, x, y);
    }

    public static void main(String[] args) {
        Result r = extendedGCD(30, 20);
        System.out.println("GCD: " + r.gcd + ", x: " + r.x + ", y: " + r.y);
    }
}
