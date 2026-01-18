class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        int left = 0; int right=n-k;
        //binary search on possible valid starting windows positions [ 0,n-k]
        while(left<right){
            int mid = left+(right-left)/2;
            if(x-arr[mid] > arr[mid+k]-x)
                left=mid+1;
            else
                right=mid;   
        }

        for(int i = left; i<left+k;i++){
            res.add(arr[i]);
        }
        return res;
        //total complexity = 0(1)+0(log(n-k))+0(k) = 0(log(n-k)+0(k))
    }
}