class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, res,selected);
        return res;
    }


    private void backtrack(List<Integer> state, int[] nums, List<List<Integer>> res,boolean[] selected){
        
         if(state.size()==nums.length){
              res.add(new ArrayList<>(state));
              return;
         }

         Set<Integer> duplicate = new HashSet<>();
         for(int i =0; i<nums.length;i++){
             //Pruning
             if(!selected[i] && !duplicate.contains(nums[i])){
                duplicate.add(nums[i]);
                selected[i] = true;
                state.add(nums[i]);
            
                backtrack(state,nums,res,selected);
               
               // Backtrack
                selected[i] = false;
                state.remove(state.size()-1);
             }

         }


    }
}