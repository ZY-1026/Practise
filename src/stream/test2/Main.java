package stream.test2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("wang", 10));
        studentList.add(new Student("zhang", 13));
        studentList.add(new Student("li", 10));
        studentList.add(new Student("zhao", 10));
        System.out.println("找出年龄为10的第一个学生：");
        Optional<Student> s = studentList.stream().filter(student -> student.getAge().equals(10)).findFirst();
        if (s.isPresent()) {
            System.out.println(s.get().getName() + "," + s.get().getAge());
        }

        System.out.println("找出年龄为10的所有学生：");
        List<Student> students = studentList.stream().filter(student -> student.getAge().equals(10)).collect(Collectors.toList());
        for (Student student : students) {
            System.out.println(student.getName() + "," + student.getAge());
        }

        System.out.println("对学生按年龄分组：");
        Map<Integer, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        Iterator<Map.Entry<Integer, List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Student>> entry = (Map.Entry<Integer, List<Student>>) iterator.next();
            int age = entry.getKey();
            System.out.println(age + ":");
            List<Student> group = entry.getValue();
            for (Student student : group) {
                System.out.println(student.getName() + "  ");
            }
            System.out.println();
        }
    }
}
