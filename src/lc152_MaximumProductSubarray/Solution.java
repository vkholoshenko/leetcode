package lc152_MaximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int all = 1, noFirstNeg = 0;

        for (int num : nums) {
            if (num > result) {
                result = num;
            }

            if (num == 0) {
                noFirstNeg = 0;
                all = 1;
            } else {
                all *= num;
                if (all > result) {
                    result = all;
                }

                if (noFirstNeg == 0 && num < 0) {
                    noFirstNeg = 1;
                } else {
                    noFirstNeg *= num;

                    if (noFirstNeg != 0 && noFirstNeg > result) {
                        result = noFirstNeg;
                    }
                }
            }
        }

        return result;
    }
}