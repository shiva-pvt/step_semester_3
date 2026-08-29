package week4.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        
        prefixSums.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            if (prefixSums.containsKey(currentSum - k)) {
                count += prefixSums.get(currentSum - k);
            }
            
            prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
