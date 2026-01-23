class Solution {
    public int findMin(int[] nums) {
       return binarySearch(nums,0,nums.length-1);
    }

    private int binarySearch(int[] nums, int low, int high) {
        // lowest number will always be less than any number on right of the array
        // if nums[mid] < nums[high] this can be potential answer search in left half of array otherwise search in right half
           int minnum=0;
            while(low<=high){
                  int mid = low+(high-low)/2;
                  if(nums[mid]<nums[high]) {minnum = nums[mid]; high = mid;} //potential answer including current mid;
                 else low = mid + 1;
            }
            return minnum == 0 ? nums[high] : minnum;
    }
}