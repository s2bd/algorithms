// Algorithm: Bucket Sort
// Type: Sorting, Non-comparison based
// Time Complexity: O(n + k) average
// Space Complexity: O(n + k)

function insertionSort(arr) {
    for (let i = 1; i < arr.length; i++) {
        let key = arr[i];
        let j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

function bucketSort(arr, bucketCount = 10) {
    if (arr.length === 0) return arr;

    let maxVal = Math.max(...arr);
    let minVal = Math.min(...arr);
    const bucketRange = (maxVal - minVal) / bucketCount;

    const buckets = Array.from({ length: bucketCount }, () => []);

    for (const num of arr) {
        let index = Math.floor((num - minVal) / bucketRange);
        if (index === bucketCount) index--;
        buckets[index].push(num);
    }

    for (const bucket of buckets) {
        insertionSort(bucket);
    }

    return [].concat(...buckets);
}
