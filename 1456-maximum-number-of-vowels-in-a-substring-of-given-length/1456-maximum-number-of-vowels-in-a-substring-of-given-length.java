class Solution {
    public int maxVowels(String s, int k) {
        int left = 0, count = 0, maxCount = 0;

        for (int right = 0; right < s.length(); right++) {
            if (isVowel(s.charAt(right))) { //whenever vowel found add it in possible count
                count++;
            }

            if (right - left + 1 == k) {
                //shrink the windows
                maxCount = Math.max(maxCount, count);

                if (isVowel(s.charAt(left))) { // decreasing count if left char found to be vowel during shrinking
                    count--;
                }
                left++;
            }
        }
        return maxCount;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
