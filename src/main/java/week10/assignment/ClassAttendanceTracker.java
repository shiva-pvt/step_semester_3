package week10.assignment;

public class ClassAttendanceTracker {

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
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] res1 = attendanceSummary(days1);
        System.out.println("Present: " + res1[0] + ", Longest streak: " + res1[1]);

        int[] days2 = {0, 0, 0};
        int[] res2 = attendanceSummary(days2);
        System.out.println("Present: " + res2[0] + ", Longest streak: " + res2[1]);
    }
}
