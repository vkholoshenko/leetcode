package llc17_LetterCombinationsPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] map = new char[][]{
                {},
                {},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}};

        List<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int idx = digits.charAt(i)  - '0';
            List<String> next = new ArrayList<>();
            for (String s : result) {
                for (char c : map[idx]) {
                    next.add(s + c);
                }
            }
            result = next;
        }

        return result;
    }
}