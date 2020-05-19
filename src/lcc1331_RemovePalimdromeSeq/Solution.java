package lcc1331_RemovePalimdromeSeq;

class Solution {
    public boolean isPalindrome(String s) {
        for (int i=0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i -1)) {
                return false;
            }
        }
        return true;
    }
    public int removePalindromeSub(String s) {
        if (s.equals("")) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }
}