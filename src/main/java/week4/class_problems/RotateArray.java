package week4.class_problems;

public class RotateArray {
    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        k = k % nums.length;
        if (k == 0) return nums;
        
        int[] newArray = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
        
        return nums;
    }
}
