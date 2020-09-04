package leetCode.mytest;

import java.util.HashMap;
import java.util.Map;

// 将16进制转化为10进制
public class ToDecimalNum {
    public static int convert(String content) {
        if (!content.matches("[0-9a-fA-F]*")) {
            System.exit(-1);
        }
        content = content.toUpperCase();
        int number = 0;
        String[] highLetter = {"A", "B", "C", "D", "E", "F"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(i + "", i);
        }
        for (int j = 10; j < highLetter.length + 10; j++) {
            map.put(highLetter[j - 10], j);
        }
        String[] str = new String[content.length()];
        for (int i = 0; i < str.length; i++) {
            str[i] = content.substring(i, i + 1);
        }
        for (int i = 0; i < str.length; i++) {
            number += map.get(str[i]) * Math.pow(16, str.length - 1 - i);
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(convert("facd"));
    }
}
