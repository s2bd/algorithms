# Hashing Collision Resolution - Open Addressing (Linear Probing)
# Avg Time: O(1), Worst: O(n)
# Space: O(n)

class HashTableOpenAddressing:
    def __init__(self, size=10):
        self.size = size
        self.table = [None] * size
        self.deleted = object()  # sentinel for deleted slots

    def hash_function(self, key):
        return key % self.size

    def insert(self, key, value):
        for i in range(self.size):
            index = (self.hash_function(key) + i) % self.size
            if self.table[index] is None or self.table[index] is self.deleted:
                self.table[index] = (key, value)
                return
            if self.table[index][0] == key:
                self.table[index] = (key, value)  # update
                return
        raise Exception("Hash Table Full")

    def search(self, key):
        for i in range(self.size):
            index = (self.hash_function(key) + i) % self.size
            if self.table[index] is None:
                return None
            if self.table[index] != self.deleted and self.table[index][0] == key:
                return self.table[index][1]
        return None

    def delete(self, key):
        for i in range(self.size):
            index = (self.hash_function(key) + i) % self.size
            if self.table[index] is None:
                return
            if self.table[index] != self.deleted and self.table[index][0] == key:
                self.table[index] = self.deleted
                return
