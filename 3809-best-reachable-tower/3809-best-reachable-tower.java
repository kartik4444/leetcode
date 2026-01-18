class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int maxQi = -1;
        int[] result = {-1, -1};
        
        for (int[] tower : towers) {
            int xi = tower[0];
            int yi = tower[1];
            int qi = tower[2];
            
            // Calculate distance
            int distance = Math.abs(xi-center[0]) + Math.abs(yi-center[1]);
         
            // Check if within radius
            if (distance <= radius) {
                // Update if better quality, or same quality but lexicographically smaller
                if (qi > maxQi || (qi == maxQi && (xi < result[0] || (xi == result[0] && yi < result[1])))) {
                    maxQi = qi;
                    result[0] = xi;
                    result[1] = yi;
                }
            }
        }
        
        return result;
    }
}