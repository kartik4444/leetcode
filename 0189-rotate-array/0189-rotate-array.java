class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //reverse entire array
        reverse(nums, 0, n - 1);
        //reverse first k elements
        reverse(nums, 0, k - 1);
        //reverse the last n-k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;

        }
    }
}