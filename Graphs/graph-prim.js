// Prim's Algorithm
// Time: O(E log V)
// Space: O(V + E)

class MinHeap {
    constructor() {
        this.heap = [];
    }
    push(item) {
        this.heap.push(item);
        this.bubbleUp();
    }
    pop() {
        if (this.heap.length === 1) return this.heap.pop();
        const top = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return top;
    }
    bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0) {
            let parent = Math.floor((index - 1) / 2);
            if (this.heap[parent][1] <= this.heap[index][1]) break;
            [this.heap[parent], this.heap[index]] = [this.heap[index], this.heap[parent]];
            index = parent;
        }
    }
    bubbleDown() {
        let index = 0;
        const length = this.heap.length;
        while (true) {
            let left = 2 * index + 1;
            let right = 2 * index + 2;
            let smallest = index;

            if (left < length && this.heap[left][1] < this.heap[smallest][1]) smallest = left;
            if (right < length && this.heap[right][1] < this.heap[smallest][1]) smallest = right;

            if (smallest === index) break;
            [this.heap[smallest], this.heap[index]] = [this.heap[index], this.heap[smallest]];
            index = smallest;
        }
    }
    isEmpty() {
        return this.heap.length === 0;
    }
}

function prim(graph, start = 0) {
    const V = graph.length;
    const visited = new Array(V).fill(false);
    const MST = [];
    const minHeap = new MinHeap();

    minHeap.push([start, 0, -1]); // vertex, weight, parent

    while (!minHeap.isEmpty()) {
        const [u, w, parent] = minHeap.pop();
        if (visited[u]) continue;
        visited[u] = true;
        if (parent !== -1) MST.push([parent, u, w]);

        for (const [v, weight] of graph[u]) {
            if (!visited[v]) {
                minHeap.push([v, weight, u]);
            }
        }
    }
    return MST;
}
