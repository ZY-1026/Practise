package leetCode.letcode155;

import java.util.PriorityQueue;
import java.util.Vector;

public class MinStack {
    public Vector<Integer> vector;
    public PriorityQueue<Integer> queue;
    public int size;

    public MinStack() {
        this.vector = new Vector<>();
        this.size = 0;
        this.queue = new PriorityQueue<>();
    }

    public void push(int x) {
        this.vector.add(x);
        this.queue.add(x);
        this.size++;
    }

    public void pop() {
        int result = vector.get(this.size - 1);
        this.vector.remove(this.size - 1);
        this.queue.remove(result);
        this.size--;
    }

    public int top() {
        return this.vector.get(this.size - 1).intValue();
    }

    public int getMin() {
        return this.queue.peek();
    }
}
