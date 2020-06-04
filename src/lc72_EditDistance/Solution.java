package lc72_EditDistance;
/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j <= word2.length(); j++) {
                char c2 = word2.charAt(j-1);

                distance[i][j] = 1 + Math.min(distance[i-1][j-1], Math.min(distance[i-1][j],distance[i][j-1]));

                if (c1 == c2 && distance[i-1][j-1] < distance[i][j]) {
                    distance[i][j] = distance[i-1][j-1];
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}