class Solution {
    public int minimumK(int[] nums) {
        // We want to find the minimum k such that we can reduce all elements to ≤ 0 
        // within k² operations (choosing k in each operation).
        // 
        // Example: [3,7,5], if k=7:
        // - 3 needs 1 operation: 3-7 = -4
        // - 7 needs 1 operation: 7-7 = 0  
        // - 5 needs 1 operation: 5-7 = -2
        // Total: 3 operations ≤ 7² = 49 ✓
        //
        // For a given k, each element num needs ceil(num/k) operations.
        // We need: sum of all operations ≤ k²
        //
        // Search space: k ranges from 1 to max(max(nums), nums.length)
        // - Lower bound: at least 1
        // - Upper bound: max value (each element takes 1 op) OR array length (if all small)
        // Binary search finds minimum valid k in O(log(max) * n) time
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            max = Math.max(max, num);
        
        int low = 1;
        int high = Math.max(max, nums.length);

        while (low < high) {
            int mid = low + (high - low) / 2;
            long moves = 0;
            
            for (int num : nums) {
                moves += (long)(num + mid - 1) / mid;  // ceiling division
            }

            if (moves <= (long) mid * mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;  // or high, they're equal
    }
}