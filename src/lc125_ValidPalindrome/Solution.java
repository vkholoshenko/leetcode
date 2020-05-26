package lc125_ValidPalindrome;

class Solution {
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        boolean result = true;

        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return result;
    }
}