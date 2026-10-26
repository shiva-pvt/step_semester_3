package week10.assignment;

import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        int shift = k % n;

        if (shift == 0) {
            return names.clone();
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        System.out.println(Arrays.toString(rotateRoster(names1, k1)));

        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        System.out.println(Arrays.toString(rotateRoster(names2, k2)));
    }
}
