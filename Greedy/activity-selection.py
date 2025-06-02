# Algorithm: Activity Selection
# Type: Greedy
# Time: O(n log n)
# Space: O(1)

def activity_selection(start, end):
    activities = sorted(zip(start, end), key=lambda x: x[1])
    selected = [activities[0]]
    last_end = activities[0][1]

    for s, e in activities[1:]:
        if s >= last_end:
            selected.append((s, e))
            last_end = e

    return selected
