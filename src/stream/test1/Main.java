package stream.test1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // 通过集合创建
        List<User> list = Arrays.asList(new User("zhangsan", 18),
                                    new User("lisi", 19),
                                    new User("wangwu", 20),
                                    new User("zhaosi", 21));
        Stream<User> stream = list.stream();
        Stream<User> userStream = list.parallelStream();

        // 通过数组创建
        Integer[] ints = new Integer[5];
        Stream<Integer> integerStream = Arrays.stream(ints);

        // 通过值创建
        Stream<String> stringStream = Stream.of("zhangsan", "lisi", "wangwu");

        // 通过函数创建
        // 迭代
        Stream<Integer> stream1 = Stream.iterate(2, (x) -> x*2).limit(4);
        stream1.forEach(System.out::println);

        //生成
        Stream<Double> stream2 = Stream.generate(Math::random).limit(4);
        stream2.forEach(System.out::println);
    }
}
