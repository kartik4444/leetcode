class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left =0; int right=n-1;
        int area = -1;
        while(left<right){
           area = Math.max(area,(Math.min(height[left],height[right]) * (right-left)));
           if(height[left]<height[right]) left++;
           else if(height[left]>height[right]) right--;
           else{
            left++;
            right--;
           }
        }
        return area;
    }
}