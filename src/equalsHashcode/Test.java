package equalsHashcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void test1() {
        System.out.println("####:interview1713");
        List<Model> list = new ArrayList<Model>();

        Model a = new Model("a", "20", "test");
        Model b = new Model("a", "20", "abcdef");
        Model c = new Model("a", "20", "");
        list.add(a);
        System.out.println("a-hashCode:" + a.hashCode());
        System.out.println(list);
        if (!list.contains(b)) {
            list.add(b);
            System.out.println("b-hc:" + b.hashCode());
            System.out.println(list);
        }

    }

    public static void test2() {
        System.out.println("####:test52");
        Set<Model> set = new HashSet<Model>();
        Model a = new Model("a", "20", "test");
        Model b = new Model("a", "20", "abcdef");
        Model c = new Model("a", "20", "");

        set.add(a);
        System.out.println("a-hashCode:" + a.hashCode());
        System.out.println(set);
        if (!set.contains(b)) {
            set.add(b);
            System.out.println("b-hc:" + b.hashCode());
            System.out.println(set);
        }

    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
