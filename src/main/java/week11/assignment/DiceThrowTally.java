package week11.assignment;

import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int v : rolls) {
            count[v]++;
        }

        StringBuilder sb = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            sb.append(v).append(":").append(count[v]);
            if (v < 6) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1));

        System.out.println();

        int[] rolls2 = {6, 5, 4, 3, 2, 1};
        int[] sorted2 = diceSort(rolls2);
        System.out.println("Sorted: " + Arrays.toString(sorted2));
    }
}
