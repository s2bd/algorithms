// Algorithm: Hash Table with Separate Chaining
// Type: Data Structure, Hashing
// Time Complexity: Average O(1) insert/search/delete; Worst O(n)
// Space Complexity: O(n)

class HashTable {
    constructor(size = 10) {
        this.size = size;
        this.table = Array.from({ length: size }, () => []);
    }

    hashFunction(key) {
        return key % this.size;
    }

    insert(key, value) {
        const index = this.hashFunction(key);
        const bucket = this.table[index];

        for (let i = 0; i < bucket.length; i++) {
            if (bucket[i][0] === key) {
                bucket[i][1] = value;
                return;
            }
        }
        bucket.push([key, value]);
    }

    search(key) {
        const index = this.hashFunction(key);
        const bucket = this.table[index];
        for (const [k, v] of bucket) {
            if (k === key) return v;
        }
        return null;
    }

    delete(key) {
        const index = this.hashFunction(key);
        const bucket = this.table[index];
        for (let i = 0; i < bucket.length; i++) {
            if (bucket[i][0] === key) {
                bucket.splice(i, 1);
                return;
            }
        }
    }
}
