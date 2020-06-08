package lc621_TaskScheduler;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.
 */
class Solution {
    static class Task {
        public int name;
        public int k;
        public Task(int name, int k) {
            this.name = name;
            this.k = k;
        }

    }
    static class TaskComparator implements Comparator<Task> {
        public int compare(Task o1, Task o2) {
            return o2.k - o1.k;
        }
        public boolean equals(Task o1, Task o2) {
            return o1.equals(o2);
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] ts = new int[26];
        for (char task : tasks) {
            ts[task-'A']++;
        }
        PriorityQueue<Task> q = new PriorityQueue<>(26, new TaskComparator());
        for (int i = 0; i < ts.length; i++) {
            if (ts[i] > 0) {
                q.add(new Task(i, ts[i]));
            }
        }
        int result = 0;

        Stack<Task> tmp = new Stack<Task>();


        // A3 B3
        while (!q.isEmpty()) {
            for (int j = 0; j <= n; j++) {
                if (tmp.isEmpty() && q.isEmpty()) {
                    break;
                }
                result++;

                if (!q.isEmpty()) {
                    Task t = q.poll();
                    t.k--;
                    if (t.k > 0) {
                        tmp.push(t);
                    }
                }
            }
            while (!tmp.isEmpty()) {
                q.add(tmp.pop());
            }
        }
        return result;
    }
}