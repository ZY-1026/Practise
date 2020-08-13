package singleton;

// 枚举模式

public class Singleton6 {

    private Singleton6() {
    }

    private enum EnumHolder {
        INSTANCE;
        private Singleton6 singleton6;

        EnumHolder() {
            this.singleton6 = new Singleton6();
        }

        private Singleton6 getSingleton6() {
            return singleton6;
        }
    }

    public static Singleton6 getInstance() {
        return EnumHolder.INSTANCE.getSingleton6();
    }
}
