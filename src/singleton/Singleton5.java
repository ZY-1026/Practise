package singleton;


// holder方式
public class Singleton5 {
    private Singleton5() {
    }

    private static class Holder {
        private static Singleton5 singleton5 = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Holder.singleton5;
    }
}
