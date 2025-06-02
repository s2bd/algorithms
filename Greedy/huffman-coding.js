// Algorithm: Huffman Coding
// Type: Greedy
// Time: O(n log n)
// Space: O(n)

class Node {
    constructor(char, freq) {
        this.char = char;
        this.freq = freq;
        this.left = this.right = null;
    }
}

function huffmanCoding(charFreq) {
    let heap = charFreq.map(([ch, freq]) => new Node(ch, freq));
    heap.sort((a, b) => a.freq - b.freq);

    while (heap.length > 1) {
        const left = heap.shift();
        const right = heap.shift();
        const newNode = new Node(null, left.freq + right.freq);
        newNode.left = left;
        newNode.right = right;
        heap.push(newNode);
        heap.sort((a, b) => a.freq - b.freq);
    }

    return heap[0];
}

function printCodes(node, code = '') {
    if (!node) return;
    if (node.char) console.log(`${node.char}: ${code}`);
    printCodes(node.left, code + '0');
    printCodes(node.right, code + '1');
}
