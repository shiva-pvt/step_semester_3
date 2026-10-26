package week10.assignment;

/**
 * Problem 7: Second-Best Score
 * 
 * Task:
 * Find the second-highest distinct score in an array of scores, or return -1
 * if no second-highest distinct score exists. Do not sort the array.
 * 
 * Complexity:
 * - Single-Pass Scan (Our Solution):
 *     Time Complexity: O(n) where n is the number of scores.
 *     Space Complexity: O(1) auxiliary space (uses only two variables).
 * - Comparison with Sorting:
 *     Sorting the array takes O(n log n) time and O(n) or O(log n) auxiliary space.
 *     Sorting would also reorder the input array, violating the problem constraint.
 *     A single pass is strictly faster and uses minimal space.
 */
public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                // Previous highest becomes the new second-highest
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                // Score is strictly less than highest but greater than current second
                second = score;
            }
            // If score == highest or score <= second, ignore it
        }

        return second;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("Sample 1 Output: " + secondHighest(scores1));
        // Expected Output: 78

        // Sample 2
        int[] scores2 = {50, 50, 50};
        System.out.println("Sample 2 Output: " + secondHighest(scores2));
        // Expected Output: -1
    }
}
