package lc5423_TwoNonOverlappingSubArrays;

class Solution {

    private int[] lens;
    private int[] sums;
    private int[] arr;
    private int target;
    private int[] mins;

    private int find(int index) {
        if (arr[index] > target) {
            return 0;
        }
        if (arr[index] == target) {
            return 1;
        }
        int l = index, r = sums.length-1;
        while (l <= r) {
            int c = (l + r) / 2;
            int cand = sums[c];
            if (index > 0) {
                cand -= sums[index-1];
            }

            if (cand == target) {
                return c - index + 1;
            } else if (cand > target) {
                r = c - 1;
            } else {
                l = c + 1;
            }
        }
        return 0;
    }

    public int minSumOfLengths(int[] arr, int target) {
        this.arr = arr;
        this.target = target;
        sums = new int[arr.length];
        lens = new int[arr.length];
        mins = new int[arr.length];
        int sum = 0;
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i] = sums[i-1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            lens[i] = find(i);
        }

        int min = arr.length + 1;
        for (int i = arr.length-1; i >= 0; i--) {
            if (lens[i] > 0 && lens[i] < min) {
                min = lens[i];
            }
            mins[i] = min;
        }

        int best = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            if (lens[i] > 0 && i + lens[i] < arr.length) {
                 best = Math.min(best, lens[i] + mins[i + lens[i]]);
            }
        }
        if (best <= arr.length) {
            return best;
        } else {
            return -1;
        }
    }
}