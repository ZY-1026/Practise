package leetCode.letcode232;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1; // 保存进队列数据
    private Stack<Integer> stack2; // 保存出队列数据
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.size = 0;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        this.stack1.push(x);
        this.size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) return -1;
        if (!this.stack2.isEmpty()) return this.stack2.pop();
        else { // 如果stack2不为空，将stack1中数据移到stack2中
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
        this.size--;
        return this.stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) return -1;
        if (!this.stack2.isEmpty()) return this.stack2.peek();
        else {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.stack2.isEmpty() && this.stack1.isEmpty();
    }
}
