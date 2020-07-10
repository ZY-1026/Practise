package collection;

import java.util.Comparator;

public class TestComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        // 比较姓名的长度
        int num = o1.getName().length() - o2.getName().length();
        // 比较姓名的字典序
        int num2 = num == 0 ? o1.getName().compareTo(o2.getName()) : num;
        // 比较年龄
        int num3 = num2 == 0 ? o1.getAge() - o2.getAge() : num2;
        return num3;
    }
}
