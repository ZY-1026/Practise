package leetCode.offer.offer40;

import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k > arr.length) return null;
        int[] result = new int[k];
        // 大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,1};
        int k = 2;
        int[] res = new Solution().getLeastNumbers(arr, k);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
