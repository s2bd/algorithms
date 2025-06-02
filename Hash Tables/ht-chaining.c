// Hashing Collision Resolution - Chaining
// Avg Time: O(1), Worst: O(n)
// Space: O(n)

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

typedef struct Node {
    int key;
    int value;
    struct Node* next;
} Node;

Node* table[SIZE];

int hashFunction(int key) {
    return key % SIZE;
}

void insert(int key, int value) {
    int index = hashFunction(key);
    Node* newNode = malloc(sizeof(Node));
    newNode->key = key;
    newNode->value = value;
    newNode->next = table[index];
    table[index] = newNode;
}

int search(int key) {
    int index = hashFunction(key);
    Node* curr = table[index];
    while (curr) {
        if (curr->key == key) return curr->value;
        curr = curr->next;
    }
    return -1; // not found
}

void delete(int key) {
    int index = hashFunction(key);
    Node *curr = table[index], *prev = NULL;
    while (curr) {
        if (curr->key == key) {
            if (prev) prev->next = curr->next;
            else table[index] = curr->next;
            free(curr);
            return;
        }
        prev = curr;
        curr = curr->next;
    }
}
