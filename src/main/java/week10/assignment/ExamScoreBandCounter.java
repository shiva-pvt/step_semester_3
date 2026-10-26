package week10.assignment;

/**
 * Problem 4: Exam Score Band Counter
 * 
 * Task:
 * Given a sorted array of exam scores (which may contain duplicates),
 * return the number of scores in the closed range [low, high].
 * Must not scan elements one by one.
 * 
 * Complexity:
 * - Linear Scan:
 *     Time Complexity: O(n) per query
 *     Space Complexity: O(1)
 * - Binary Search (Our Solution):
 *     Time Complexity: O(log n) per query
 *     Space Complexity: O(1) auxiliary space
 * 
 * Impact of Duplicates at Edges:
 * A standard binary search stops as soon as it finds any matching element, which could
 * be in the middle of duplicate values at the boundary. To include all valid duplicates:
 * 1. Find the FIRST index where score >= low (lower bound of low).
 * 2. Find the FIRST index where score > high (upper bound of high, or lower bound of high + 1).
 * The count is then: upperBound - lowerBound.
 */
public class ExamScoreBandCounter {

    // Finds the first index where scores[index] >= target
    private static int findLowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length; // points past the end

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int start = findLowerBound(scores, low);
        int end = findLowerBound(scores, high + 1);

        return end - start;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        // Sample 1
        int ans1 = countInBand(scores, 42, 58);
        System.out.println("Sample 1 Output: " + ans1);
        // Expected Output: 6

        // Sample 2
        int ans2 = countInBand(scores, 90, 100);
        System.out.println("Sample 2 Output: " + ans2);
        // Expected Output: 0
    }
}
