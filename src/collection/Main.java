package collection;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Set<Student> set = new TreeSet<>(new TestComparator());
////        set.add(new Student("Bob", 26));
////        set.add(new Student("Alice", 21));
////        set.add(new Student("Joe", 25));
////        set.add(new Student("Sum", 26));
////        set.add(new Student("Kafka", 24));
////        for (Student stu : set) {
////            System.out.println(stu.getName() + "----------" + stu.getAge());

        String s1 = new StringBuilder("计算机") .append("软件").toString();
        System.out.println(s1.intern() == s1);

//        String s2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s2.intern() == s2);

    }
    }
//}
