class Solution {
    public int subsetXORSum(int[] nums) {
         int totalsum = 0;
        return solve(0,nums,new ArrayList<>(),0);
    }

    public int solve(int index,int[] nums,List<Integer> curr,int sum){

         if(index>=nums.length) {
         int xor = 0;
           for(int i : curr){
              xor = i ^ xor;
           }
              return xor;
         }

         //pick the sum
         curr.add(nums[index]);
         int picksum  = solve(index+1,nums,curr,sum); 

         //backtrack 
          curr.remove(curr.size()-1);
           
         //not pick the sum
         int notpicksum = solve(index+1,nums,curr,sum);

         return picksum + notpicksum;
    }
}