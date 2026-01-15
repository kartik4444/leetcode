class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int right = 0; right < n; right++) {
             if(!mp.containsKey(nums[right])){
                mp.put(nums[right],right);
             }
             else{
                int pastindex = mp.get(nums[right]);
                if(Math.abs(pastindex-right)<=k) return true;
                else
                mp.put(nums[right],right);
             }
        }
        return false;

    }
}