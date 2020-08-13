package singleton;

public class Singleton3 {
    private static Singleton3 singleton3 = null;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (null == singleton3) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
