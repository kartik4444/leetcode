class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);   // sort to handle duplicates
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void solve(int index, int[] nums,
                      List<Integer> current,
                      List<List<Integer>> result) {

        // base case: all elements considered
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Take nums[index]
        current.add(nums[index]);
        solve(index + 1, nums, current, result);
        current.remove(current.size() - 1);  // backtrack

        // Skip nums[index] (and skip duplicates!)
        // only skip if next number is the same to avoid duplicates
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        solve(nextIndex, nums, current, result);
    }
}
