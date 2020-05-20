package lc5_Palindrome;

class Solution {
    public boolean isPalindrome(String s, int start, int end)
    {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int best = 0;
        String result = "";
        for (int start = 0; start < s.length(); start++) {
            for (int end = start + best; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    best = end - start + 1;
                    result = s.substring(start, end+1);
                }
            }
        }
        return result;
    }
}
