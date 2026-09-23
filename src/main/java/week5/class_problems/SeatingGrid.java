package week5.class_problems;

public class SeatingGrid {
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            sb.append("Row ").append(i).append(": ");
            if (avg >= threshold) {
                sb.append("Buzzing Zone");
            } else {
                sb.append("Quiet Zone");
            }
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;
        System.out.println(classifyRows(seatingScores, threshold));
    }
}
