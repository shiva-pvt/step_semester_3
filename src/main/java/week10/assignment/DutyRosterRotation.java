package week10.assignment;

import java.util.Arrays;

/**
 * Problem 8: Duty Roster Rotation
 * 
 * Task:
 * Rotate a roster array to the right by k places.
 * Elements that move past the end wrap around to the front.
 * 
 * Complexity:
 * - Time Complexity: O(n) where n is the number of names.
 * - Space Complexity: O(n) to store the result array.
 * 
 * Why rotating one place at a time k times is slow:
 * Rotating 1 step at a time requires shifting all n elements. Repeating this k times
 * takes O(n * k) time. Since k can be as large as 10^9, n * k can reach 10^11 operations,
 * which is far too slow and causes timeout. Using k % n eliminates full loops and directly
 * maps index i to (i + k) % n in O(n) time.
 */
public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        int shift = k % n; // remove full rotations

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
        // Sample 1
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        System.out.println(Arrays.toString(rotateRoster(names1, k1)));
        // Expected Output: [D, E, A, B, C]

        // Sample 2
        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        System.out.println(Arrays.toString(rotateRoster(names2, k2)));
        // Expected Output: [D, E, A, B, C]
    }
}
