package lc155_MinStack;

import java.util.Stack;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
        if (this.minStack.empty()) {
            this.minStack.push(x);
        } else {
            this.minStack.push(Math.min(x, this.minStack.peek()));
        }
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}

