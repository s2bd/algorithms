// Algorithm: Hash Table with Separate Chaining
// Type: Data Structure, Hashing
// Time Complexity: Average O(1) insert/search/delete; Worst O(n)
// Space Complexity: O(n)

import java.util.LinkedList;

class HashNode {
    int key, value;
    HashNode(int k, int v) { key = k; value = v; }
}

public class HashTable {
    private int size = 10;
    private LinkedList<HashNode>[] table;

    public HashTable() {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) table[i] = new LinkedList<>();
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key, int value) {
        int index = hashFunction(key);
        for (HashNode node : table[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        table[index].add(new HashNode(key, value));
    }

    public Integer search(int key) {
        int index = hashFunction(key);
        for (HashNode node : table[index]) {
            if (node.key == key) return node.value;
        }
        return null;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        table[index].removeIf(node -> node.key == key);
    }
}
