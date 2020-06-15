package lc1478_AllocateMailboxes;

import java.util.Arrays;

public class Solution {
    public int[][] buildUsing1(int[] houses) {
        int[][] result = new int[houses.length][houses.length];
        for (int j = 0; j < houses.length-1; j++) {
            result[1][j] = houses[j+1] - houses[j];
        }
        for (int j = 0; j < houses.length-2; j++) {
            int mi = j;
            for (int i = 2; i < houses.length-j; i++) {
                if (i % 2 == 0) mi++;
                result[i][j] = houses[i+j] + result[i-1][j] - houses[mi];
            }
        }
        return result;
    }

    public int minDistance(int[] houses, int k) {
        if (houses.length <= k) return 0;

        Arrays.sort(houses);
        int[][] using1 = buildUsing1(houses);
        for (int j = 0; j < houses.length-1; j++) {
            using1[1][j] = houses[j+1] - houses[j];
        }

        int[][] previous = using1, current = null;
        for (int postCount = 2; postCount <= k; postCount++) {
            current = new int[houses.length][houses.length];
            for (int i = postCount; i < houses.length; i++) {
                for (int j = 0; j < houses.length-i; j++) {
                    int min = previous[i][j];
                    for (int t = 0; t < i; t++) {
                        int opt = using1[t][j] + previous[i-t-1][j+t+1];
                        if (opt < min) min = opt;
                    }
                    current[i][j] = min;
                }

            }
            previous = current;
        }

        return previous[houses.length-1][0];
    }
}
