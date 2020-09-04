package leetCode.letcode347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null || nums.length == 0 || k > nums.length) return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 按照Value值进行排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        List<Integer> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        Collections.sort(list);
        int size = list.size();
        int[] topK = new int[size];
        for (int i = 0; i < size; i++) {
            topK[i] = list.get(i);
        }
        return topK;
    }
}
