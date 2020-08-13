package sort;

public class Main {

    public void doSomething() {
        synchronized (this) {
            System.out.println("1111111");
        }
    }

    public static void main(String[] args) {
        new Main().doSomething();
    }
}
