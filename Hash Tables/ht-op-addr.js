// Hashing Collision Resolution - Open Addressing (Linear Probing)
// Avg Time: O(1), Worst: O(n)
// Space: O(n)

class HashTableOpenAddressing {
    constructor(size = 10) {
        this.size = size;
        this.table = new Array(size).fill(null);
        this.DELETED = { deleted: true };
    }

    hashFunction(key) {
        return key % this.size;
    }

    insert(key, value) {
        for (let i = 0; i < this.size; i++) {
            const index = (this.hashFunction(key) + i) % this.size;
            const entry = this.table[index];
            if (entry === null || entry === this.DELETED || entry.key === key) {
                this.table[index] = { key, value };
                return;
            }
        }
        throw new Error("Hash Table Full");
    }

    search(key) {
        for (let i = 0; i < this.size; i++) {
            const index = (this.hashFunction(key) + i) % this.size;
            const entry = this.table[index];
            if (entry === null) return null;
            if (entry !== this.DELETED && entry.key === key) return entry.value;
        }
        return null;
    }

    delete(key) {
        for (let i = 0; i < this.size; i++) {
            const index = (this.hashFunction(key) + i) % this.size;
            const entry = this.table[index];
            if (entry === null) return;
            if (entry !== this.DELETED && entry.key === key) {
                this.table[index] = this.DELETED;
                return;
            }
        }
    }
}
