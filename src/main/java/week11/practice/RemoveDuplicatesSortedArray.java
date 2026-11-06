package week11.practice;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writeIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIdx] = nums[i];
                writeIdx++;
            }
        }

        return writeIdx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(nums);

        System.out.println("length = " + len);
        int[] uniquePart = Arrays.copyOfRange(nums, 0, len);
        System.out.println("nums[0.." + (len - 1) + "] = " + Arrays.toString(uniquePart));
    }
}
