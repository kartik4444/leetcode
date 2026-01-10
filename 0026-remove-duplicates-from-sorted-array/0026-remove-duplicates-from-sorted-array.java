class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        int idx=0;
        for(int i=0;i <n;i++){
              //if present in set then continue;
              if(s.contains(nums[i])) continue;
               //not present in set 
              else{
                  s.add(nums[i]);
                  nums[idx++] = nums[i];
              } 

        }
        return idx;
    }
}