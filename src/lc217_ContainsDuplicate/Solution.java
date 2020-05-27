package lc217_ContainsDuplicate;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> found = new HashSet<>();

        for (int num : nums) {
            if (found.contains(num)) {
                return true;
            }
            found.add(num);
        }

        return false;
    }
}