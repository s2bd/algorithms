// Algorithm: RRT*
// Type: Sampling-based Path Planning
// Time: O(n log n), Space: O(n)

class Node {
    constructor(x, y, cost = 0, parent = null) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.parent = parent;
    }
}

function distance(a, b) {
    return Math.hypot(a.x - b.x, a.y - b.y);
}

function steer(from, to, step = 1.0) {
    const dist = distance(from, to);
    const theta = Math.atan2(to.y - from.y, to.x - from.x);
    return new Node(from.x + step * Math.cos(theta), from.y + step * Math.sin(theta), from.cost + step, from);
}
