package leetCode.interview1602;

import java.util.HashMap;

public class WordsFrequency {
    public HashMap<String, Integer> hashMap = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String tmp : book) {
            hashMap.merge(tmp, 1, (oldVal, newVal) -> oldVal + newVal);
        }
    }

    public int get(String word) {
        return hashMap.getOrDefault(word, 0);
    }
}
