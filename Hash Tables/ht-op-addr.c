// Hashing Collision Resolution - Open Addressing (Linear Probing)
// Avg Time: O(1), Worst: O(n)
// Space: O(n)

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10
#define EMPTY -1
#define DELETED -2

typedef struct {
    int key;
    int value;
} Entry;

Entry table[SIZE];

void initTable() {
    for (int i = 0; i < SIZE; i++) {
        table[i].key = EMPTY;
        table[i].value = 0;
    }
}

int hashFunction(int key) {
    return key % SIZE;
}

void insert(int key, int value) {
    for (int i = 0; i < SIZE; i++) {
        int index = (hashFunction(key) + i) % SIZE;
        if (table[index].key == EMPTY || table[index].key == DELETED || table[index].key == key) {
            table[index].key = key;
            table[index].value = value;
            return;
        }
    }
    printf("Hash Table Full\n");
}

int search(int key) {
    for (int i = 0; i < SIZE; i++) {
        int index = (hashFunction(key) + i) % SIZE;
        if (table[index].key == EMPTY) return -1;
        if (table[index].key == key) return table[index].value;
    }
    return -1;
}

void delete(int key) {
    for (int i = 0; i < SIZE; i++) {
        int index = (hashFunction(key) + i) % SIZE;
        if (table[index].key == EMPTY) return;
        if (table[index].key == key) {
            table[index].key = DELETED;
            return;
        }
    }
}
