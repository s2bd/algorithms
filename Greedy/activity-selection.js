// Algorithm: Activity Selection
// Type: Greedy
// Time: O(n log n)
// Space: O(1)

function activitySelection(start, end) {
    const activities = start.map((s, i) => ({ start: s, end: end[i] }));
    activities.sort((a, b) => a.end - b.end);

    const selected = [activities[0]];
    let lastEnd = activities[0].end;

    for (let i = 1; i < activities.length; i++) {
        if (activities[i].start >= lastEnd) {
            selected.push(activities[i]);
            lastEnd = activities[i].end;
        }
    }

    return selected;
}
