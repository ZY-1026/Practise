package bishi.fiveEight;

import java.util.*;

public class Solution1 {

    public static ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        // write code here
        ArrayList<String> arrayList = new ArrayList<>();
        if (values == null) return arrayList;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            ArrayList<String> list = values.get(i);
            for (int j = 0; j < list.size(); j++) {
                hashMap.put(list.get(j), hashMap.getOrDefault(list.get(j), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == values.size()) {
                arrayList.add(entry.getKey());
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
}
