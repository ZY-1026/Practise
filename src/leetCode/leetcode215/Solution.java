package leetCode.letcode215;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return -1;
        // 小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 根据前面k个元素创建小根堆
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            int heapNum = priorityQueue.peek();
            if (nums[i] > heapNum) {
                priorityQueue.remove(); // 移除堆顶元素
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek().intValue();
    }
}
