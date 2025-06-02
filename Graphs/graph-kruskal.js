// Kruskal's Algorithm
// Time: O(E log E)
// Space: O(V)

class UnionFind {
    constructor(n) {
        this.parent = Array.from({length: n}, (_, i) => i);
        this.rank = Array(n).fill(0);
    }
    find(u) {
        if (this.parent[u] !== u) {
            this.parent[u] = this.find(this.parent[u]);
        }
        return this.parent[u];
    }
    union(u, v) {
        let rootU = this.find(u);
        let rootV = this.find(v);
        if (rootU === rootV) return false;

        if (this.rank[rootU] < this.rank[rootV]) this.parent[rootU] = rootV;
        else if (this.rank[rootV] < this.rank[rootU]) this.parent[rootV] = rootU;
        else {
            this.parent[rootV] = rootU;
            this.rank[rootU]++;
        }
        return true;
    }
}

function kruskal(edges, V) {
    edges.sort((a, b) => a[2] - b[2]);
    const uf = new UnionFind(V);
    const MST = [];

    for (const [u, v, w] of edges) {
        if (uf.union(u, v)) {
            MST.push([u, v, w]);
        }
    }
    return MST;
}
