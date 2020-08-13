package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("jay");
        list.add("tianluo");
        // List 转Array，必须使用集合的 toArray(T[] array)
        String[] array = list.toArray(new String[list.size()]);
        System.out.println(array[0]);

        // Array转List
        String[] str = new String[]{"Jey", "TianLuo"};
        List list1 = Arrays.asList(str);
        for (int i=0;i<list1.size();i++){
            System.out.println(list1.get(i));
        }
        /**
         * 运行时会报错
         *  Arrays.asList不是返回java.util.ArrayList,
         *  而是一个内部类ArrayList
         */
       // list1.add("boy");

        // 弥补
        // 方法一
        ArrayList<String> arrayList = new ArrayList<>(str.length);
        Collections.addAll(arrayList, str);
        arrayList.add("BOY");
        for (String tmp : arrayList){
            System.out.println(tmp);
        }

        // 方法二
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(str));
        for (String tmp : list2){
            System.out.println(tmp);
        }
    }
}
