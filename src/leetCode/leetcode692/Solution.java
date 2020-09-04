package leetCode.letcode692;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (words == null || words.length == 0 || k > words.length) return arrayList;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String word : words) {
            treeMap.put(word, treeMap.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());
        // 降序排列
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        int index = 1;
        for (Map.Entry<String, Integer> tmp : list) {
            if (index > k) break;
            arrayList.add(tmp.getKey());
            index++;
        }
        return arrayList;
    }
}
