package lc134_GasStation;
/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0;
        for (int i = 0; i < gas.length; i++)
            balance = balance + gas[i] - cost[i];
        if (balance < 0) return -1;

        int[] data = new int[gas.length];
        data[0] = gas[cost.length-1] - cost[cost.length-1];
        int mi = 0;
        for (int i = 1; i < gas.length; i++) {
            data[i] = data[i-1] + gas[i-1] - cost[i-1];
            if (data[i] < data[mi]) mi = i;
        }

        return mi;
    }
}