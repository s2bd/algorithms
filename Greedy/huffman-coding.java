// Algorithm: Huffman Coding
// Type: Greedy
// Time: O(n log n)
// Space: O(n)

import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch; this.freq = freq;
    }
}

class Huffman {
    public static Node buildTree(List<Node> nodes) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
        pq.addAll(nodes);

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node merged = new Node('\0', left.freq + right.freq);
            merged.left = left; merged.right = right;
            pq.add(merged);
        }

        return pq.poll();
    }

    public static void printCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + ": " + code);
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }
}
