// Algorithm: Activity Selection
// Type: Greedy
// Time: O(n log n)
// Space: O(1)

import java.util.*;

class Activity {
    int start, end;
    Activity(int s, int e) { start = s; end = e; }
}

public class ActivitySelector {
    public static void selectActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.end));
        System.out.println("Selected Activities:");
        Activity last = activities.get(0);
        System.out.println("(" + last.start + ", " + last.end + ")");

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start >= last.end) {
                last = activities.get(i);
                System.out.println("(" + last.start + ", " + last.end + ")");
            }
        }
    }
}
