import java.util.*;

class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> nonNeg = new ArrayList<>();
        
        // Step 1: collect non-negative elements
        for (int x : nums) {
            if (x >= 0) {
                nonNeg.add(x);
            }
        }
        
        int m = nonNeg.size();
        if (m == 0) return nums; // nothing to rotate
        
        // Step 2: normalize k
        k %= m;
        
        // Step 3: left rotate non-negative elements
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(nonNeg.subList(k, m));
        rotated.addAll(nonNeg.subList(0, k));
        
        // Step 4: put back rotated values
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = rotated.get(idx++);
            }
        }
        
        return nums;
    }
}
