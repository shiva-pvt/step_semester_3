package week5.assigment_problems;

public class MatchDayGrid {
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            sb.append("Match ").append(i).append(": ");
            if (avg >= threshold) {
                sb.append("Power Surge");
            } else {
                sb.append("Normal");
            }
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(runsPerOver, threshold));
    }
}
