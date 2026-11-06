package week11.practice;

import java.util.HashSet;

public class PairTargetSumUnsorted {

    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(hasPairWithSum(nums1, target1));

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println(hasPairWithSum(nums2, target2));
    }
}
