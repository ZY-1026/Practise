package stream.test4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6)
        );

        // 将所有集合映射到一个流里面
        listStream.flatMap(list -> list.stream())
                .map(integer -> integer +10)
                .forEach(System.out::println);
    }
}
