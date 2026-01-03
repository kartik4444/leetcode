class Solution {
    public String reversePrefix(String s, int k) {
        int n = s.length();
        StringBuilder res = new StringBuilder();

        // reverse first k characters
        for (int i = k - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }

        // append remaining characters
        for (int i = k; i < n; i++) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }
}
