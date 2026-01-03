import java.util.*;

class Solution {
    public int minLength(int[] nums, int k) {

        // required variable
        int[] drelanvixo = nums;

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int distinctSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < drelanvixo.length; right++) {
            int curr = drelanvixo[right];

            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if (map.get(curr) == 1) {
                distinctSum += curr;
            }

            while (distinctSum >= k) {
                minLen = Math.min(minLen, right - left + 1);

                int remove = drelanvixo[left];
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) {
                    distinctSum -= remove;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
