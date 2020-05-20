package lc5_Palindrome;

class Solution {
    public String longestPalindrome(String s) {
        int best = 0;
        String result = "";
        for (int i = 0; i < s.length() - best / 2; i++) {
            for (int r = 0; r < 2; r++) {
                int size = 0;
                while (i - size >= 0 && i + size + r < s.length() &&
                        s.charAt(i - size) == s.charAt(i + size + r)) {
                    size++;
                }
                int found = (size - 1) * 2 + r + 1;
                if (found > best) {
                    best = found;
                    result = s.substring(i - size + 1, i + size + r);
                }
            }
        }
        return result;
    }
}