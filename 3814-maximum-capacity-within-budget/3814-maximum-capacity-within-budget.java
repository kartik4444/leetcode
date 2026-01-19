class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int maxCap = 0;
        
        // Create and sort pairs by cost
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = costs[i];
            items[i][1] = capacity[i];
        }
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        
        // Check single items
        for (int i = 0; i < n; i++) {
            if (items[i][0] < budget) {
                maxCap = Math.max(maxCap, items[i][1]);
            }
        }
        
        // For each item, binary search for valid pairs and track max capacity
        int[] maxCapacityUpTo = new int[n]; // Max capacity from index 0 to i
        maxCapacityUpTo[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxCapacityUpTo[i] = Math.max(maxCapacityUpTo[i-1], items[i][1]);
        }
        
        // For each item as right, find all valid left items
        for (int right = 1; right < n; right++) {
            int remainingBudget = budget - items[right][0];
            
            // Binary search for rightmost item with cost < remainingBudget
            int left = 0, r = right - 1;
            int bestIdx = -1;
            
            while (left <= r) {
                int mid = left + (r - left) / 2;
                if (items[mid][0] < remainingBudget) {
                    bestIdx = mid;
                    left = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            if (bestIdx != -1) {
                // Pair with the item having max capacity in range [0, bestIdx]
                maxCap = Math.max(maxCap, items[right][1] + maxCapacityUpTo[bestIdx]);
            }
        }
        
        return maxCap;
    }
}