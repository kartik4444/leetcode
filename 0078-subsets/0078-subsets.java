class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }

    public void backtrack(int[] nums, int index, List<Integer> current,List<List<Integer>> result ){

        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        //left call, take nums[index]
        current.add(nums[index]);
        backtrack(nums,index+1,current,result);

        //right call, skip nums[index]
        current.remove(current.size()-1);
        backtrack(nums,index+1,current,result);

    }
}