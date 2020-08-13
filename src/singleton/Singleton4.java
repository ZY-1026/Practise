package singleton;

// 双重检测机制
public class Singleton4 {

    private volatile static Singleton4 singleton4 = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (null == singleton4) {
            synchronized (Singleton4.class) {
                if (null == singleton4) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
