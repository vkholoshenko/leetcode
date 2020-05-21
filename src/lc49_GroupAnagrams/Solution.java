package lc49_GroupAnagrams;

import java.util.*;

class Solution {
    public String canonical(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < chars[i]; j++) {
                sb.append('a' + i);
            }
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            String can = canonical(s);
            ArrayList<String> list = map.get(can);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(can, list);
        }

        Iterator it = map.entrySet().iterator();
        ArrayList<List<String>> result = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            result.add((ArrayList<String>)me.getValue());
        }
        return result;
    }
}