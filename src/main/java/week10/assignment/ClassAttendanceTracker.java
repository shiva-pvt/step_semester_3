package week10.assignment;

/**
 * Problem 6: Class Attendance Tracker
 * 
 * Task:
 * Calculate the total number of days a student was present (1s) and the
 * longest unbroken streak of present days from a binary array.
 * 
 * Complexity:
 * - Time Complexity: O(n) where n is the length of the days array.
 *   Both answers are found in a single pass through the array.
 * - Space Complexity: O(1) auxiliary space, using only counters.
 */
public class ClassAttendanceTracker {

    // Returns [presentDays, longestStreak]
    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0; // reset streak on absence
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    public static void main(String[] args) {
        // Sample 1
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] res1 = attendanceSummary(days1);
        System.out.println("Present: " + res1[0] + ", Longest streak: " + res1[1]);
        // Expected Output: Present: 6, Longest streak: 3

        // Sample 2
        int[] days2 = {0, 0, 0};
        int[] res2 = attendanceSummary(days2);
        System.out.println("Present: " + res2[0] + ", Longest streak: " + res2[1]);
        // Expected Output: Present: 0, Longest streak: 0
    }
}
