package lc131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> first = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            first.add(s.substring(i, i+1));
        }

        List<List<String>> current = new ArrayList<>();
        current.add(first);

        while (!current.isEmpty()) {
            List<List<String>> next = new ArrayList<>();
            for (List<String> subresult : current) {
                result.add(subresult);
                for (int i = subresult.size()-1; i > 0; i--) {
                    String c = subresult.get(i);
                    String p1 = subresult.get(i-1);
                    String p2 = "";
                    if (i-2 >= 0) p2 = subresult.get(i-2);

                    if (c.length() > 1) break;
                    if (c.equals(p1)) {
                        List<String> found = new ArrayList<>();
                        for (int j = 0; j < i-1; j++) found.add(subresult.get(j));
                        found.add(p1+c);
                        for (int j = i+1; j < subresult.size(); j++) found.add(subresult.get(j));
                        next.add(found);
                    }
                    if (c.equals(p2)) {
                        List<String> found = new ArrayList<>();
                        for (int j = 0; j < i-2; j++) found.add(subresult.get(j));
                        found.add(p2+p1+c);
                        for (int j = i+1; j < subresult.size(); j++) found.add(subresult.get(j));
                        next.add(found);
                    }
                }
            }
            current = next;
        }
        return result;

    }
}