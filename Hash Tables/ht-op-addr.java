// Hashing Collision Resolution - Open Addressing (Linear Probing)
// Avg Time: O(1), Worst: O(n)
// Space: O(n)

public class HashTableOpenAddressing {
    private static final int SIZE = 10;
    private static final int EMPTY = -1;
    private static final int DELETED = -2;

    private int[] keys = new int[SIZE];
    private int[] values = new int[SIZE];

    public HashTableOpenAddressing() {
        for (int i = 0; i < SIZE; i++) keys[i] = EMPTY;
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void insert(int key, int value) {
        for (int i = 0; i < SIZE; i++) {
            int index = (hashFunction(key) + i) % SIZE;
            if (keys[index] == EMPTY || keys[index] == DELETED || keys[index] == key) {
                keys[index] = key;
                values[index] = value;
                return;
            }
        }
        throw new RuntimeException("Hash Table Full");
    }

    public Integer search(int key) {
        for (int i = 0; i < SIZE; i++) {
            int index = (hashFunction(key) + i) % SIZE;
            if (keys[index] == EMPTY) return null;
            if (keys[index] == key) return values[index];
        }
        return null;
    }

    public void delete(int key) {
        for (int i = 0; i < SIZE; i++) {
            int index = (hashFunction(key) + i) % SIZE;
            if (keys[index] == EMPTY) return;
            if (keys[index] == key) {
                keys[index] = DELETED;
                return;
            }
        }
    }
}
