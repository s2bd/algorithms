// Algorithm: Hash Table with Separate Chaining
// Type: Data Structure, Hashing
// Time Complexity: Average O(1) insert/search/delete; Worst O(n)
// Space Complexity: O(n)

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

typedef struct Node {
    int key;
    int value;
    struct Node* next;
} Node;

Node* hashTable[SIZE];

int hashFunction(int key) {
    return key % SIZE;
}

void insert(int key, int value) {
    int index = hashFunction(key);
    Node* newNode = malloc(sizeof(Node));
    newNode->key = key;
    newNode->value = value;
    newNode->next = hashTable[index];
    hashTable[index] = newNode;
}

int search(int key) {
    int index = hashFunction(key);
    Node* curr = hashTable[index];
    while (curr != NULL) {
        if (curr->key == key) return curr->value;
        curr = curr->next;
    }
    return -1; // not found
}

void delete(int key) {
    int index = hashFunction(key);
    Node* curr = hashTable[index];
    Node* prev = NULL;
    while (curr != NULL) {
        if (curr->key == key) {
            if (prev == NULL) hashTable[index] = curr->next;
            else prev->next = curr->next;
            free(curr);
            return;
        }
        prev = curr;
        curr = curr->next;
    }
}
