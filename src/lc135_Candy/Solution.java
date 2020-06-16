package lc135_Candy;
/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length < 2) return ratings.length;
        int result = 1;
        int i = 1;
        int n = ratings.length;
        int curr = 1;
        while (i < n && ratings[i] < ratings[i-1]) {
            curr++;
            result += curr;
            i++;
        }
        while (i < n) {
            curr = 1;
            while (i < n && ratings[i] == ratings[i-1]) {
                result++;
                i++;
            }
            while (i < n && ratings[i] > ratings[i-1]) {
                curr++;
                result += curr;
                i++;
            }
            if (i < n) {
                int peek = curr;
                curr = 1;
                while (i < n && ratings[i] < ratings[i - 1]) {
                    curr++;
                    result += curr;
                    i++;
                }
                result = result - Math.min(peek, curr) + 1;
            }
        }
        return result;
    }
}