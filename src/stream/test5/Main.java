package stream.test5;

import stream.test1.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("zhangsan", 18),
                new User("lisi", 21),
                new User("wangwu", 19),
                new User("zhaoliu", 20));
        list.stream().map(x -> x.getAge()).sorted().forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(x->x.getName())).forEach(System.out::println);
    }
}
