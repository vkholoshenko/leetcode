package lc155_MinStack;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStackFailed {
    private Stack<Integer> stack;
    private HashMap<Integer, Integer> map;
    private PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public MinStackFailed() {
        this.stack = new Stack<>();
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>();
    }

    public void push(int x) {
        this.stack.push(x);
        this.map.put(x, this.map.getOrDefault(x, 0)+1);
        this.pq.add(x);
    }

    public void pop() {
        int x = this.stack.pop();
        this.map.put(x, this.map.get(x) - 1);
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        while (true) {
            int x = this.pq.peek();
            if (this.map.get(x) > 0) {
                return x;
            }
            this.pq.poll();
        }
    }

}
