package lc31_NextPermutation;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int ci;
        int p = nums[nums.length-1];
        for (ci = nums.length - 1; ci > 0; ci--) {
            if (nums[ci] > nums[ci-1]) {
                int j=nums.length-1;
                while (nums[j] <= nums[ci-1]) j--;
                int t = nums[j];
                nums[j] = nums[ci-1];
                nums[ci-1] = t;
                break;
            }
        }

        int l = ci;
        int r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}