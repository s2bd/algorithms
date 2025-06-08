// Algorithm: RRT*
// Type: Sampling-based Path Planning
// Time: O(n log n), Space: O(n)

class Node {
    double x, y, cost;
    Node parent;

    Node(double x, double y) {
        this.x = x; this.y = y; cost = 0;
    }
}

double distance(Node a, Node b) {
    return Math.hypot(a.x - b.x, a.y - b.y);
}

Node steer(Node from, Node to, double step) {
    double dist = distance(from, to);
    double theta = Math.atan2(to.y - from.y, to.x - from.x);
    return new Node(from.x + step * Math.cos(theta),
                    from.y + step * Math.sin(theta));
}
