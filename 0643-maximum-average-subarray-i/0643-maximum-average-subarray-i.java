class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];   // expand window

            // when window size becomes k
            if (right - left + 1 == k) {
                maxAvg = Math.max(maxAvg, sum * 1.0 / k);

                // shrink window
                sum -= nums[left];
                left++;
            }
        }

        return maxAvg;
    }
}
