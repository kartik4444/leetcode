class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum = 0, split = 0;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    split++;
                    sum = num;
                }
            }

            if (split + 1 > k) // split not possible move to right with higher mid
                low = mid + 1;
            else
                high = mid - 1; //split possible move to left to minimize the ans
        }

        return low; // low converges to the answer
    }
}