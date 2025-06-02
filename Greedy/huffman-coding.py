# Algorithm: Huffman Coding
# Type: Greedy
# Time: O(n log n)
# Space: O(n)

import heapq

class Node:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = self.right = None

    def __lt__(self, other):
        return self.freq < other.freq

def huffman_coding(char_freq):
    heap = [Node(c, f) for c, f in char_freq]
    heapq.heapify(heap)

    while len(heap) > 1:
        left = heapq.heappop(heap)
        right = heapq.heappop(heap)
        merged = Node(None, left.freq + right.freq)
        merged.left, merged.right = left, right
        heapq.heappush(heap, merged)

    return heap[0]

def print_codes(node, code=""):
    if not node:
        return
    if node.char:
        print(f"{node.char}: {code}")
    print_codes(node.left, code + "0")
    print_codes(node.right, code + "1")
