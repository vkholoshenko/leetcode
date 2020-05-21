package lc20_ValidParentheses;

class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack[pointer++] = c;
            } else if (pointer > 0 &&
                    (c == ')' && stack[pointer-1] == '(' ||
                            c == ']' && stack[pointer-1] == '[' ||
                            c == '}' && stack[pointer-1] == '{')) {
                pointer--;
            } else {
                return false;
            }
        }
        return pointer==0;
    }
}