package leetCode.letcode225;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1; // 保存入栈元素
    private Queue<Integer> queue2; // 保存出栈元素

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) queue2.add(queue1.poll());
        int ans = queue1.poll();
        while (queue2.size() > 0) queue1.add(queue2.poll());
        return ans;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queue1.size() > 1)
            queue2.add(queue1.poll());
        int ans = queue1.peek();
        queue2.add(queue1.poll());
        while (queue2.size() > 0)
            queue1.add(queue2.poll());
        return ans;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

