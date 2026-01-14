class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0, maxSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int rVal = nums[right];
            sum += rVal;
            freq.put(rVal, freq.getOrDefault(rVal, 0) + 1);

            if (right - left + 1 > k) {
                int lVal = nums[left];
                sum -= lVal;
                int count = freq.get(lVal);
                if (count == 1) {
                    freq.remove(lVal);
                } else {
                    freq.put(lVal, count - 1);
                }
                left++;
            }

            if (right - left + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
