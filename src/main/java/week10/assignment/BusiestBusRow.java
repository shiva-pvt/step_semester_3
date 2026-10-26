package week10.assignment;

/**
 * Problem 10: Busiest Bus Row
 * 
 * Task:
 * A college bus records how many students sit in each seat as a 2D grid,
 * where each row is one row of seats. Find which row carries the most students.
 * If two rows tie, return the one with the smaller index.
 * 
 * Complexity:
 * - Time Complexity: O(r * c) where r is the number of rows and c is the number of columns.
 *   We visit every seat in the grid exactly once.
 * - Space Complexity: O(1) auxiliary space, as only a few primitive variables are used.
 */
public class BusiestBusRow {

    // Returns an array containing [bestRowIndex, maxTotal]
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowSum += grid[r][c];
            }

            // Update only if rowSum is strictly larger (ties keep smaller index)
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRow = r;
            }
        }

        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
        // Expected Output: Row 1, Total 7
    }
}
