package lc60_PermSeq;

class Solution {
    public String getPermutation(int n, int k) {
        // n = 3, k = 4
        int[] alphabet = new int[n];
        int result = 0;
        int nf = 1;
        k--;
        for (int i = 1; i <= n; i++) {
            nf *= i;
        }
        // nf = 6
        for (int i = 0; i < n; i++) {
            alphabet[i] = i + 1;
        }
        // [1 2 3]

        for (int i = 0; i < n; i++) {
            nf = nf / (n - i); // 1 / 1 = 1
            int index = k / nf; // 1 / 1 = 1
            k = k % nf; // 0 / 1 = 0

            result = result * 10 + alphabet[index]; // 231
            for (int j = index + 1; j < n - i; j++) {
                alphabet[j - 1] = alphabet[j];
            }

        }
        return String.valueOf(result);
    }
}