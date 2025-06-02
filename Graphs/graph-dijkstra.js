// Dijkstra's Algorithm
// Time: O((V + E) log V)
// Space: O(V)

class PriorityQueue {
    constructor() {
        this.nodes = [];
    }
    enqueue(priority, key) {
        this.nodes.push({key, priority});
        this.nodes.sort((a, b) => a.priority - b.priority);
    }
    dequeue() {
        return this.nodes.shift();
    }
    isEmpty() {
        return this.nodes.length === 0;
    }
}

function dijkstra(graph, start) {
    const dist = {};
    for (const node in graph) dist[node] = Infinity;
    dist[start] = 0;

    const pq = new PriorityQueue();
    pq.enqueue(0, start);

    while (!pq.isEmpty()) {
        const {key: node, priority: currentDist} = pq.dequeue();

        if (currentDist > dist[node]) continue;

        for (const [neighbor, weight] of graph[node]) {
            const distance = currentDist + weight;
            if (distance < dist[neighbor]) {
                dist[neighbor] = distance;
                pq.enqueue(distance, neighbor);
            }
        }
    }
    return dist;
}
