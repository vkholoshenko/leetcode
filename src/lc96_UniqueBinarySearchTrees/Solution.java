package lc96_UniqueBinarySearchTrees;

/*
Given n, how many structurally unique
 BST's (binary search trees) that store values 1 ... n?
 */
public class Solution {
    private int[] cache;

    public int numTrees(int n) {
        if (n == 0) return 0;
        cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i<=n; i++) {
            for (int j = 0; j < i; j++) {
                cache[i] += (cache[j] * cache[i-j-1]);
            }
        }
        return cache[n];
    }
}