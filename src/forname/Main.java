package forname;


import sun.applet.AppletClassLoader;

/**
 * 验证forname()函数和classloader()之间的区别
 */

class Point {
    static {
        System.out.println("loading point");
    }

    int x, y;
}

class Line {
    static {
        System.out.println("loading line");
    }
}

public class Main {
    public static void main(String[] args) {
        // 调用对象的getClass()方法
        Point p = new Point();
        Class a = p.getClass();
        System.out.println("a   " + a.getName());


        Class b = Point.class;
        System.out.println("b  " + b.getName());
        System.out.println(".............................");
        String point = "forname.Point";
        try {
            Class c1 = Class.forName(point);
            System.out.println("c1   " + c1.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(".............................");
        String line = "forname.Line";
        Class<?> demo = null;

        // 初始化classloader
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        try {
            demo = loader.loadClass(line); // Line类中的静态代码块不会执行
            System.out.println("demo   " + demo.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("................................");
        try {
            Line line1 = (Line) (demo != null ? demo.newInstance() : null); // 调用demo.newInstance() 会执行Line类中的静态代码块
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
