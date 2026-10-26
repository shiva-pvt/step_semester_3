package week10.assignment;

public class ExamScoreBandCounter {

    private static int findLowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

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

        int ans1 = countInBand(scores, 42, 58);
        System.out.println(ans1);

        int ans2 = countInBand(scores, 90, 100);
        System.out.println(ans2);
    }
}
