/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int n = mountainArr.length();
        int lans = binarySearch(mountainArr, 0, peak, target, true);
        if (lans != -1)
            return lans;
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    private int binarySearch(MountainArray arr, int low, int high, int target, boolean isLeftSide) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = arr.get(mid);
            if (num == target)
                return mid;
            else if (num > target) {
                if (isLeftSide)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (isLeftSide)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }
        return -1;
    }

    private int findPeak(MountainArray arr) {
        int low = 0;
        int high = arr.length() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int num = arr.get(mid);
            int after = arr.get(mid + 1);
           if (num < after)
                low = mid+1;
            else
             high = mid;
        }
        return low;
    }
}