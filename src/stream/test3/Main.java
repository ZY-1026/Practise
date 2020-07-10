package stream.test3;

import stream.test1.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("zhangsan",18),
                new User("lisi",19),
                new User("wangwu", 20),
                new User("wangwu",20),
                new User("zhaosi",21));

        //去重
        list.stream()
                // 筛选出年龄大于19的用户
                .filter(user -> user.getAge()>=19)
                //截取两个用户
                .limit(2)
                .forEach(System.out::println);
    }
}
