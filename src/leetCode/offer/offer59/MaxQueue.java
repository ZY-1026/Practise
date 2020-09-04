package offer.test59;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    // 双向队列,保存单调递减的元素
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxQueue.isEmpty() && value > maxQueue.getLast())
            maxQueue.pollLast();
        maxQueue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int ans = queue.poll();
        if (ans == maxQueue.peek())
            maxQueue.poll();
        return ans;
    }
}
