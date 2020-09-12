package leetCode.leetcode347;

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

    public int[] topKFrequentII(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0 || k < 0) return res;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 21);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (index == k) break;
            res[index] = entry.getKey();
            index++;
        }
        return res;
    }
}
